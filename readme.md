# 🛒 Sistema de Vendas com Java Swing e MySQL
**Autor:** Tiago Santana Ferreira 
**Data:** 19 de julho de 2025  
**Versão:** 1.0

## ⚙️ Funcionalidades

- Listagem de produtos com **ID, Nome, Valor e Status**.
- Venda de produtos por **ID**.
- Consulta de histórico de vendas.
- Integração com banco de dados **MySQL**.
- Interface simples e funcional com Java Swing.

---

## 🧱 Tecnologias Utilizadas

- Java SE 8+ (recomendado usar JDK 17 ou superior)
- Java Swing (GUI)
- JDBC (Java Database Connectivity)
- MySQL Server
- NetBeans 22 (IDE)

---

## 🗃️ Estrutura do Banco de Dados (MySQL)

### 📌 Tabela: 'produtos'

'''sql
CREATE TABLE produtos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) DEFAULT 'Disponível'
);