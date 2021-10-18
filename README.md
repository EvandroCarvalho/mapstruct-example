# Utilizando mapstruct

## Indice
1. [Mapper](#Mapper)
3. [MapStruct](#MapStruct)
4. [Dependências](#Dependências)
5. [Configuração](#Configuração)
6. [Exemplo](/src/main/java/com/example/mapstruct/mapper/AddressMapper.java)
7. [Documentação](https://mapstruct.org/)

# Mapper
Mapper é um padrão muito utilizado para mapemaneto entre objetos, comumente para o DTO. Como é algo comum, 
existem  várias libs que abstraem a implementação, facilitando a vida do desenvolvedor e reduzindo o 
[boilerplate](https://pt.wikipedia.org/wiki/Boilerplate_code).

Como dito anteriormente existem várias libs, como por exemplo o Modelmapper, JMapper, DozerMaapper, etc... Existes também alguns converters como por 
exemplo um do próprio Spring que é uma interface `Converter<IN, OUT>` de implementação que utiliza da vantagem que trabalhar com injeção de 
dependência 


# MapStruct
É uma das mais libs rápidas, o <i>mapstruct</i> gera código em tempo de compilação, com isso é possível 
ver o código e entender melhor como é o processo, ele não utiliza <i>reflection</i> como alguns 
outros, e isso é muito importante pois facilida a vida da JVM e deixa o processo mais rápido. 

[Aqui](https://www.baeldung.com/java-performance-mapping-frameworks) tem um exemplo de <i>benchmark</i> que 
mostra o quando o <i>mapstruct</i> é rápido se comparado aos demais. 

Além dos pontos apresentados, é possível utilizar objetos imutavéis, algo que gosto de priorizar no 
desenvolvimentos de soluções, pois traz vários benefícios (sugiro pesquisar sobre as vantagens de se 
trabahar com imutabilidade). E esta implementação é bem simples, ainda mais se utilizado anotações 
do lombok `@Builder` e `@Value` (a nível de conhecimento, o @Value é o @Data imutavel - 
[link](https://projectlombok.org/features/Value)).


# Dependências

```
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>${mapstruct.version}</version>
        <scope>compile</scope>
    </dependency>

    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct-processor</artifactId>
        <version>${mapstruct.version}</version>
    </dependency>

```


* Importante incluir configuração para que o código gerado do mapstruct não de conflito com o do lombok

```
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.0</version>
				<configuration>
					<annotationProcessorPaths>
						<path>
							<groupId>org.mapstruct</groupId>
							<artifactId>mapstruct-processor</artifactId>
							<version>${mapstruct.version}</version>
						</path>
						<path>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
							<version>${lombok.version}</version>
						</path>
					</annotationProcessorPaths>
					<compilerArgs>
						<compilerArg>-Amapstruct.defaultComponentModel=spring</compilerArg>
					</compilerArgs>
				</configuration>
			</plugin>
```

# Configuração
Criar uma inteface, anotar com `@Mapper`, para incluir no contexto do spring, coloque a propriedade <i>componentModel="spring"</i>, Ex.: ``@Mapper(componentModel = "spring")
``

Para quando os atributos forem diferentes

``@Mapping(target = "destino", source = "origem")``

Ex.:

``@Mapping(target = "firstName", source = "person.firstName")``

Para um objeto que possui uma associação ou composição

```
    @Mapping(source = ".", target = "localizacao")
    AddressDto from(Address address);
      
    @Mapping(source = "localidade", target = "cidade")
    @Mapping(source = "uf", target = "estado")
    Localizacao toLocalizacao(Address address);
      
```
