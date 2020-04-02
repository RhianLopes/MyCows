# 🐮 MyCows

MyCows is a project created on 23 Mar 2020, the initial idea of the project is a application to manage milk cows on a farm. The objective is create a app, web and api application, with intention to studie, pratice and help people to manage your farm with a open-source project. 

## 🔥 Technology

- Java
- Maven
- Spring Boot
- Spring Data JPA
- JavaScript
- ReactJS


## 💻 Commit

Commit messages must follow the following pattern:

```
<type>(<scope>): <topic>
```
#### Example:
```
feat(UserLogin): add the persistence data in the User Login
fix: ajusts all bugs on User persistence
```

### 🥇 Type:

The Type refers to what type of commit it is, whether they are...

- ```feat```: New features or new Tests
- ```fix```: Bug fixing or testing
- ```refactor```: Code improvement or Business Rule increase
- ```remove```: Remove code

### 📖 Scope:

The Scope must serve to reference a Functionality, Document or Architecture, ex: ```UserLogin, README, Order...```.

Must be written in [American English](https://www.inglesnapontadalingua.com.br/2011/05/o-ingles-americano-tambem-tem-forma.html), exception of cases where reference is made to some external Technology or Api in another language.

Must be written following the pattern [CamelCase](http://java-hunters.blogspot.com/2014/12/o-padrao-camelcase.html) in its writing, except in cases where several files and functionalities are modified.

### 🎞 Topic:

Subject should also be written in American English, as well as the Scope, and should not have any accents in your writing.

The subject should briefly and clearly summarize what was done, modified or removed in the commit.

## 🏝 Branch

### 🧱 Architecture

The project must have the following branch structures...

```
o --> (master)
| 
| o --> (test [opcional]) 
| | 
| | o --> (develop)
| | |
| | |\
| | | | --> (feature/fix/refactor/remove)
| | | |
| | |/
| | |
| | |
| |/
| |
|/
|
o
```

#### (master):

It is the main branch, it must be protected, protected from commits directly on it, and it must be the branch that will be "In Production", that is, accessible to the end user via the server.

#### (test):

It is the homologation branch, the branch responsible for the quality part of new features or bug fixes, it must be exactly the same as the ``` master``` branch added with new features or bug solutions that will be subject to change by the quality. The ```(test)``` branch is optional, as the quality part is not present in all projects, so it is up to the team to decide on its existence.

Another optional decision is the access of the ```test``` branch for approval, referring to whether it is on any public, private or local server, it must be decided between the team.

#### (develop): 

It is the main branch for the development team, that is, it must be mandatory. The idea of its existence is that of the developer to carry out tests to check if any unforeseen happened with the new functionality or solution, another reason for its existence is the wait for other parts of the solution among developers. It must be a copy of the ```test``` branch, if it does not exist the ```master``` branch should be used to copy it.

It is also optional to access the ```test``` branch, but unlike it, the ```develop``` branch, if present on any server, should only be accessed by the developers to perform functional tests.

#### (feature/fix/refactor/remove):

The branches are responsible for functionalities, solutions and code removal. To create a new branch with any of the aforementioned responsibilities, it must be created from the branch ```develop```, made the solution, it must be updated based on the branch ``` develop```, in in case of conflicts, they must be resolved and after that open the Pull Request or Merge Request directly via the repository versioning platform.

All branches should not be accessible via the server, only locally by the Developer responsible for the task.

### 🎯 Pattern

For branch creation, the following pattern must be followed:

```
<type>/<scope>
```

Example:
```
feature/user-login-persistence
fix/user-order
```

#### Type: 

The types given to the branchs must be those presented below:

- ```feature```: New features
- ```fix```: Adjust files
- ```refactor```: Improvements or Rewrites
- ```remove```: Removing files

#### Scope:

The scope must have a brief, clear and short way, which approach is the branch. It must be written with the letters and words in lower case, lower case, and the words must be separated using ``` - ``` dashes.
