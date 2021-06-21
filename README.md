# CRUD-java

Um sistema de gestão de tarefas simples feito em java, jpa, jsf, maven.
Nele você pode cadastrar responsaveis e para cada responsavel pode-se ter várias tarefas, as tarefas tem os seguintes campos titulo, descrição, deadline, responsavel 
e prioridade.
Jpa foi usado para criar nossas tabelas no banco de dados com base nas classes criadas acelarando o processo de riação do banco, as telas foram feitas com a tecnologia
jsf que tem várias bibliotecas que facilatam a criação dessas telas e também foi usado o mavem uma ferramenta de gerenciamento de dependencias, em um arquivo pom.xml 
coloca as dependencias que serão usadas no projeto e ele automatiza o download delas.

# Rodar o projeto

Baixe a pasta crud ou clone este repositório em sua maquina, importe a pasta crud para a IDE que você utiliza, caso seja o eclipse, entre no site da mvn repository e
baixe o lombok, abra o arquivo baixado deixe ele achar eclipse e clique em install/update, depois de instalado clique em quit installer. Para integrar o projeto ao seu 
banco, vá ao arquivo persistence.xml que está em src/main/resources e substitua os values das tags "property" pelas a do seu banco de dados, por exemplo eu usei o postgreSQL então fica value="org.postgresql.Driver", você pode achar essas configurações do site do banco que você usa, vão ser elas as do driver, url, user e senha, na property que tem "hibernate.dialect" você deve procurar as configurações de acordo com a versão do seu banco, e quando for rodar a primeira vez trocar na property hibernate.hbm2ddl.auto o seu value por create, para que ele crie as tabelas. O server usado foi o tomcat v9.0, voce deve adicionar o projeto a ele para rodar.
