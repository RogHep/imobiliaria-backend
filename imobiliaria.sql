-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Tempo de geração: 08/12/2025 às 23:29
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `imobiliaria`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `bairros`
--

CREATE TABLE `bairros` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `cep_inicial` varchar(255) DEFAULT NULL,
  `cep_final` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `bairros`
--

INSERT INTO `bairros` (`id`, `nome`, `cidade`, `estado`, `cep_inicial`, `cep_final`, `created_at`, `updated_at`) VALUES
(1, 'Centro', 'Carazinho', 'RS', '00000-000', '99999-999', '2025-11-27 23:27:58', '2025-11-27 23:27:58'),
(2, 'Vila Rica', 'Carazinho', 'RS', '00000-000', '99999-999', '2025-11-27 23:27:58', '2025-11-27 23:27:58'),
(3, 'Floresta', 'Carazinho', 'RS', '00000-000', '99999-999', '2025-11-27 23:27:58', '2025-11-27 23:27:58');

-- --------------------------------------------------------

--
-- Estrutura para tabela `fotos_imoveis`
--

CREATE TABLE `fotos_imoveis` (
  `id` int(11) NOT NULL,
  `imovel_id` int(11) NOT NULL,
  `nome_arquivo` varchar(255) NOT NULL,
  `caminho` varchar(255) NOT NULL,
  `capa` varchar(255) DEFAULT NULL,
  `ordem` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `fotos_imovel`
--

CREATE TABLE `fotos_imovel` (
  `id` int(11) NOT NULL,
  `caminho` varchar(255) DEFAULT NULL,
  `capa` varchar(255) DEFAULT NULL,
  `nome_arquivo` varchar(255) DEFAULT NULL,
  `ordem` int(11) DEFAULT NULL,
  `imovel_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `fotos_imovel`
--

INSERT INTO `fotos_imovel` (`id`, `caminho`, `capa`, `nome_arquivo`, `ordem`, `imovel_id`) VALUES
(8, 'C:\\Users\\Public\\Pictures\\1764549021114_23d1dcbe633b450c1f27d286255c3ab8.jpg', 'N', '1764549021114_23d1dcbe633b450c1f27d286255c3ab8.jpg', NULL, 13),
(9, 'C:\\Users\\Public\\Pictures\\1764549076851_P466-FOTOS_11-Foto-1024x576.jpg', 'S', '1764549076851_P466-FOTOS_11-Foto-1024x576.jpg', NULL, 12),
(10, 'C:\\Users\\Public\\Pictures\\1764549101701_7.webp', 'N', '1764549101701_7.webp', NULL, 12),
(11, 'C:\\Users\\Public\\Pictures\\1764550667262_7.webp', 'N', '1764550667262_7.webp', NULL, 14),
(12, 'C:\\Users\\Public\\Pictures\\1764550680513_P466-FOTOS_11-Foto-1024x576.jpg', 'S', '1764550680513_P466-FOTOS_11-Foto-1024x576.jpg', NULL, 14);

-- --------------------------------------------------------

--
-- Estrutura para tabela `imoveis`
--

CREATE TABLE `imoveis` (
  `id` int(11) NOT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `descricao` text DEFAULT NULL,
  `preco_venda` decimal(15,2) DEFAULT NULL,
  `preco_aluguel` decimal(15,2) DEFAULT NULL,
  `finalidade` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `dormitorios` int(11) DEFAULT NULL,
  `banheiros` int(11) DEFAULT NULL,
  `garagem` int(11) DEFAULT NULL,
  `area_total` decimal(15,2) DEFAULT NULL,
  `tipo_imovel_id` int(11) DEFAULT NULL,
  `area_construida` decimal(15,2) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `caracteristicas` text DEFAULT NULL,
  `destaque` tinyint(1) DEFAULT 0,
  `bairro_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `imoveis`
--

INSERT INTO `imoveis` (`id`, `titulo`, `descricao`, `preco_venda`, `preco_aluguel`, `finalidade`, `status`, `dormitorios`, `banheiros`, `garagem`, `area_total`, `tipo_imovel_id`, `area_construida`, `endereco`, `numero`, `complemento`, `cep`, `caracteristicas`, `destaque`, `bairro_id`, `usuario_id`, `created_at`, `updated_at`) VALUES
(12, 'Casa ', 'casa mista', 450000.00, 0.00, 'venda', 'inativo', 2, 1, 2, 45.00, 1, 45.00, 'Aracaju', '201', 'Casa', '98280000', '', 0, 1, NULL, '2025-11-27 23:29:29', '2025-11-27 23:29:29'),
(13, 'Apartamento', 'SEmi imobiliado', 300000.00, 0.00, 'venda', 'inativo', 2, 2, 1, 50.00, 2, 50.00, 'Avenida', '51', 'AP', '98280000', '', 0, 1, NULL, '2025-11-30 00:42:55', '2025-11-30 00:42:55'),
(14, 'Apartamento', 'Novo', 450000.00, 0.00, 'venda', 'inativo', 1, 2, 1, 42.00, 3, 42.00, 'Bloco C', '55', 'AP', '98280000', '', 0, 2, NULL, '2025-11-30 23:49:02', '2025-11-30 23:49:02');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tipos_imoveis`
--

CREATE TABLE `tipos_imoveis` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tipos_imoveis`
--

INSERT INTO `tipos_imoveis` (`id`, `nome`, `descricao`, `created_at`, `updated_at`) VALUES
(1, 'Casa', 'Residencial', '2025-11-27 23:20:19', '2025-11-27 23:20:19'),
(2, 'Apartamento', 'Residencial', '2025-11-27 23:20:19', '2025-11-27 23:20:19'),
(3, 'Sala Comercial', 'Comercial', '2025-11-27 23:20:19', '2025-11-27 23:20:19'),
(4, 'Terreno', 'Área para construção', '2025-11-27 23:20:19', '2025-11-27 23:20:19');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `nome`, `email`, `senha`, `tipo`, `created_at`, `updated_at`) VALUES
(1, 'Admin', 'admin@local', 'senha123', 'ADMIN', '2025-11-26 02:20:32', '2025-11-26 02:20:32');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `bairros`
--
ALTER TABLE `bairros`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `fotos_imoveis`
--
ALTER TABLE `fotos_imoveis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `imovel_id` (`imovel_id`);

--
-- Índices de tabela `fotos_imovel`
--
ALTER TABLE `fotos_imovel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK63q63fwjlae508imekcb17f1j` (`imovel_id`);

--
-- Índices de tabela `imoveis`
--
ALTER TABLE `imoveis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tipo_imovel_id` (`tipo_imovel_id`),
  ADD KEY `bairro_id` (`bairro_id`),
  ADD KEY `usuario_id` (`usuario_id`);

--
-- Índices de tabela `tipos_imoveis`
--
ALTER TABLE `tipos_imoveis`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `bairros`
--
ALTER TABLE `bairros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `fotos_imoveis`
--
ALTER TABLE `fotos_imoveis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `fotos_imovel`
--
ALTER TABLE `fotos_imovel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `imoveis`
--
ALTER TABLE `imoveis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de tabela `tipos_imoveis`
--
ALTER TABLE `tipos_imoveis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `fotos_imoveis`
--
ALTER TABLE `fotos_imoveis`
  ADD CONSTRAINT `fotos_imoveis_ibfk_1` FOREIGN KEY (`imovel_id`) REFERENCES `imoveis` (`id`);

--
-- Restrições para tabelas `fotos_imovel`
--
ALTER TABLE `fotos_imovel`
  ADD CONSTRAINT `FK63q63fwjlae508imekcb17f1j` FOREIGN KEY (`imovel_id`) REFERENCES `imoveis` (`id`);

--
-- Restrições para tabelas `imoveis`
--
ALTER TABLE `imoveis`
  ADD CONSTRAINT `imoveis_ibfk_1` FOREIGN KEY (`tipo_imovel_id`) REFERENCES `tipos_imoveis` (`id`),
  ADD CONSTRAINT `imoveis_ibfk_2` FOREIGN KEY (`bairro_id`) REFERENCES `bairros` (`id`),
  ADD CONSTRAINT `imoveis_ibfk_3` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
