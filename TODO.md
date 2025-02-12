
### **1️⃣ Funcionalidades Principais**

✅ **Registrar medições de pressão** (data, hora, pressão)  
✅ **Visualizar histórico de medições** (listar por data, filtrar por períodofs)  
✅ **Gerar relatório em PDF** (gerar o PDF apenas)  
✅ **Exportação dos dados**  (salvar localmente)

---

# IGNORAR POR ENQUANTO

### **2️⃣ Funcionalidades Extras**

🔹 **Notificações e Lembretes** → Alertar para medir a pressão em horários específicos  
🔹 **Gráficos de Evolução** → Exibir tendência da pressão ao longo do tempo  
🔹 **Níveis de Risco** → Mostrar se a pressão está normal, elevada ou crítica  
🔹 **Suporte a Múltiplos Usuários** → Caso queira monitorar outras pessoas também  
🔹 **Login e Sincronização** → Para acessar de diferentes dispositivos

---

### **3️⃣ Tecnologias Sugeridas**

- **Backend:** Java + Spring Boot (caso queira uma API) ou um app standalone com JavaFX
- **Banco de Dados:** SQLite (se for um app local) ou PostgreSQL/MySQL (se for web)
- **Geração de PDF:** Biblioteca **iText** ou **Apache PDFBox**
- **Interface Gráfica:** JavaFX (desktop) ou uma API com um app frontend (React, Flutter)
- **Gráficos:** JavaFX Charts ou alguma lib de geração de gráficos para PDF

---

### **4️⃣ Fluxo do Sistema**

1️⃣ **Usuário registra uma nova medição** → Digita os valores ou insere via integração (caso use um dispositivo compatível no futuro)  
2️⃣ **Sistema armazena os dados** → Salva localmente ou em um banco  
3️⃣ **Histórico de medições** → Exibe dados organizados por data  
4️⃣ **Geração de relatório** → Usuário seleciona período e gera um PDF  
5️⃣ **Exportação e compartilhamento** → Salva, imprime ou envia por e-mail
	 
---

### **5️⃣ Próximos Passos**

🔹 Definir se será **um sistema local (JavaFX + SQLite)** ou **uma API + App Web/Mobile**  
🔹 Criar um **protótipo da interface** para ver como a experiência do usuário será  
🔹 Implementar um **CRUD simples para registro de medições**  
🔹 Adicionar a **geração de PDF e gráficos**


## LIKS ÚTEIS

DOCS CONNECTOR-J: https://dev.mysql.com/doc/connector-j/en/

## ALGUMAS IDEIAS

Quando for filtragem das datas aparecer uma modal perguntando se o usuário quer digitar uma data específica ou a data de hoje;
DATA NO FOMRATO = "ANO-MÊS-DIA"

