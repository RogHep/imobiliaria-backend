package com.example.demo.controllers;

import com.example.demo.Dtos.FotoImovelDTO;
import com.example.demo.models.FotoImovelModel;
import com.example.demo.models.ImovelModel;
import com.example.demo.services.FotoImovelService;
import com.example.demo.services.ImovelService;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/fotos")
@CrossOrigin(origins = "*")
public class FotoImovelController {

    @Autowired
    private FotoImovelService fotoService;

    @Autowired
    private ImovelService imovelService;

    private static final String DIRETORIO_UPLOAD = "C:\\Users\\Public\\Pictures";

    // =====================================================
    // FUNÇÃO PARA LIMPAR NOME DO ARQUIVO
    // =====================================================
    private String limparNome(String nome) {
        if (nome == null) return "arquivo.jpg";
        return nome
                .replaceAll("[^a-zA-Z0-9\\.\\-]", "_")
                .replaceAll("\\s+", "_");
    }

    // =====================================================
    // 1) UPLOAD DE FOTO
    // =====================================================
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> salvar(
            @RequestPart("arquivo") MultipartFile arquivo,
            @RequestPart("dados") String dadosJson
    ) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            FotoImovelDTO dto = mapper.readValue(dadosJson, FotoImovelDTO.class);

            ImovelModel imovel = imovelService.find(dto.getImovelId());
            if (imovel == null) {
                return ResponseEntity.badRequest().body("Imóvel não encontrado.");
            }

            File dir = new File(DIRETORIO_UPLOAD);
            if (!dir.exists()) dir.mkdirs();

            String nomeLimpo = limparNome(arquivo.getOriginalFilename());
            String nomeArquivo = System.currentTimeMillis() + "_" + nomeLimpo;

            Path caminho = Paths.get(DIRETORIO_UPLOAD, nomeArquivo);

            try (InputStream is = arquivo.getInputStream()) {
                Files.copy(is, caminho);
            }

            FotoImovelModel foto = new FotoImovelModel();
            foto.setNomeArquivo(nomeArquivo);
            foto.setCaminho(caminho.toString());
            foto.setCapa(dto.getCapa());
            foto.setOrdem(dto.getOrdem());
            foto.setImovel(imovel);

            fotoService.insert(foto);

            return ResponseEntity.ok("Foto salva com sucesso!");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Erro ao salvar foto: " + e.getMessage());
        }
    }

    // =====================================================
    // 2) LISTAR FOTOS DO IMÓVEL
    // =====================================================
    @GetMapping("/imovel/{id}")
    public ResponseEntity<List<FotoImovelModel>> listarPorImovel(@PathVariable Long id) {
        return ResponseEntity.ok(fotoService.findByImovelId(id));
    }

    // =====================================================
    // 3) EXIBIR ARQUIVO NO NAVEGADOR
    // =====================================================
    @GetMapping("/arquivo/{nomeArquivo}")
    public ResponseEntity<byte[]> exibirImagem(@PathVariable String nomeArquivo) throws IOException {

        Path caminho = Paths.get(DIRETORIO_UPLOAD, nomeArquivo);

        if (!Files.exists(caminho)) {
            return ResponseEntity.notFound().build();
        }

        byte[] arquivo = Files.readAllBytes(caminho);

        String contentType = Files.probeContentType(caminho);
        if (contentType == null) contentType = "image/jpeg";

        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(arquivo);
    }

    // =====================================================
    // 4) EXCLUIR FOTO
    // =====================================================
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        try {
            FotoImovelModel foto = fotoService.find(id);

            if (foto == null) {
                return ResponseEntity.notFound().build();
            }

            // Remove arquivo físico
            Path caminho = Paths.get(foto.getCaminho());
            if (Files.exists(caminho)) {
                Files.delete(caminho);
            }

            // Remove do banco
            fotoService.delete(id);

            return ResponseEntity.ok("Foto removida com sucesso!");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Erro ao excluir foto: " + e.getMessage());
        }
    }
}
