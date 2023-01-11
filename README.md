# Edge-Disjoint Partitioning

Create sub-graphs and generate the shortest path for a graph

## Archive file
https://drive.google.com/drive/folders/1IP4jUSxVdIVl4-gu5jlJdTo6NwGn0kTD?usp=sharing
## Repository

https://github.com/Tejasvedagiri/DBMS_EDP

## Setting up environment

### Java (Java 11) and maven 3.3.

Download and install Java11 or higher.

```
git clone https://github.com/Tejasvedagiri/DBMS_EDP.git
cd /DBMS_EDP
```

### Dataset
The complete data is hosted in google drive with the following link.
https://drive.google.com/drive/folders/1FV8FfkiX3kd-DsfOJEzmkgTGnCBCuv9N?usp=share_link

### Dataset generation code
https://github.com/adityam945/sub-graphs
### Compiling

```
maven clean install
```

## Arguments/Parameters for code

* Add Arguments
    * go to Run -> Run…
    * specify command line arguments for, and then select the arguments tab.
    * enter the arguments

```
  ARGS1 --File Path           		    Local File path (dataset)   Integer
  ARGS2 --No. of partitions   		    Number of label partitions  Integer
  ARGS3 --Unique vertex count 		    ##                          Integer
  ARGS4 --No. of queries to be executed     ##                          Integer
  ARGS5 --Source node id (optional)         ##                          Integer
  ARGS6 --Target node id (optional)         ##                          Integer
  ARGS7 --Index partitions size             ##                          Integer
```

## End to end Run
Sample command after maven clean install
```
mvn clean install
cd target
java -jar DBMS_EDP-1.0-SNAPSHOT-jar-with-dependencies.jar data/unit_test.txt 3 9 100 1 9 2
java -jar DBMS_EDP-1.0-SNAPSHOT-jar-with-dependencies.jar data/main_small.txt 46 3734 20000 1 9 20
```
### Running on high-end servers
```
java -jar DBMS_EDP-1.0-SNAPSHOT-jar-with-dependencies.jar data/output_10221_4_1_1000_20_10.txt 11 1000 1000 1 9 5
java -jar DBMS_EDP-1.0-SNAPSHOT-jar-with-dependencies.jar data/output_10221_4_1_1000_20_10.txt 11 1000 1000 1 9 5
java -jar DBMS_EDP-1.0-SNAPSHOT-jar-with-dependencies.jar data/output_10221_4_1_1000_20_10.txt 11 1000 1000 1 9 5

java -jar DBMS_EDP-1.0-SNAPSHOT-jar-with-dependencies.jar data/output_603052_4_1_10000_120_100.txt 10000 10000 1000000 5 561 100
java -jar DBMS_EDP-1.0-SNAPSHOT-jar-with-dependencies.jar data/output_603052_4_2_10000_120_100.txt 10000 10000 1000000 52 300 100
java -jar DBMS_EDP-1.0-SNAPSHOT-jar-with-dependencies.jar data/output_603052_4_3_10000_120_100.txt 10000 10000 1000000 75 2301 100
```