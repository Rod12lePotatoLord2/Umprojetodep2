# Sistema de Acompanhamento de Hábitos Saudáveis

**Disciplina:** Programação 2\
**Professora:** Aêda Monalliza Cunha de Sousa Brito\
**Data:** 07/12/2025\
**Alunos:**
- Juliana de Andrade Silva --- julianaandrade123
- Gabriel Acácio Vasconcelos Sampaio --- Gabriel-Acacio08
- Rodrigo Lima Barbosa --- Rod12lePotatoLord2

------------------------------------------------------------------------

## 1. Introdução

Este relatório apresenta a evolução do projeto por meio de seu histórico
de commits. O objetivo é demonstrar o progresso incremental, organização
do código e divisão de responsabilidades entre os integrantes.

------------------------------------------------------------------------

## 2. Histórico de Commits (Organizado)

### Outubro 2025

**27/10 --- Rodrigo**
- Primeiro commit, criação do repositório.

**31/10 --- Juliana**
- Estrutura inicial do projeto.
- Merge inicial com README remoto.

------------------------------------------------------------------------

### Novembro 2025

#### 01/11 --- Juliana

-   Adição das camadas bases do projeto (service, controller,
    repository).

#### 03/11 --- Rodrigo

Grande implementação do módulo de hábitos:
- Classes de domínio (Habito, Sono, Alimentação, Atividade Física).
- Repositórios JSON.
- Services e Controllers.
- Handlers de exceção e classes de erro.
- Organização de pacotes.
- Remoção de estruturas antigas.

#### 04/11 --- Juliana

-   Criação do CRUD de usuário.

#### 06/11 --- Juliana

-   Adição de JSON às classes e abstração de usuários.

#### 08/11 --- Rodrigo

-   Implementação de HabitoController, HabitoService e
    JsonHabitoRepository.
-   Ajustes nos modelos de usuário.

#### 10/11 --- Rodrigo & Gabriel

-   CRUD completo de registro.
-   Relatório diário adicionado.
-   Atualização do README.
-   Sincronização develop ↔ main.

#### 13/11 --- Gabriel

-   Ajustes finais antes de atualizar develop.

#### 14/11 --- Juliana

-   Implementação da camada exception.
-   Implementação de UsuarioService e UsuarioRepository.

#### 16/11 --- Rodrigo

-   HabitoController v2 + persistência atualizada.
-   Refino do serviço de hábito e merge das branches feature.

#### 17/11 --- Juliana

-   Adição do UsuarioController.
-   Correções em JsonUtil para polimorfismo.
-   Padronização e melhorias em repositórios e exceções.
-   Ajustes em validação de e-mail e persistência JSON.

#### 20/11 --- Gabriel

-   Ajustes finais do CRUD de registros.
-   Merge da develop.

#### 25--26/11 --- Juliana

-   Correções de conflitos.
-   Ajustes de importações.
-   Remoção de diretórios obsoletos.

#### 27/11 --- Gabriel

-   Padronização de IDs.
-   Correção dos serviços de registro e hábito.
-   Integração entre módulos.

#### 29/11 --- Juliana

-   Adição de construtores vazios em classes essenciais.

------------------------------------------------------------------------

### Dezembro 2025

#### 07/12 --- Rodrigo & Gabriel

-   Atualização e renomeação do README.
-   Implementação final do CRUD.
-   Atualizações em repositórios JSON.
-   Ajuste de tipoUsuario para desserialização.
-   Merge final da develop na main.

------------------------------------------------------------------------

## 3. Conclusão

O histórico evidencia a colaboração contínua entre os três
desenvolvedores, o uso consistente de boas práticas de versionamento e a
evolução progressiva do sistema. O projeto atingiu sua versão final
totalmente funcional, com CRUD completo para usuários, hábitos e
registros, além de persistência em JSON e tratamento robusto de
exceções.
