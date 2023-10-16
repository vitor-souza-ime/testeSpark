package org.example;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class Main {
    public static void main(String[] args) {
        // Configurar a aplicação Spark
        SparkConf conf = new SparkConf().setAppName("ContarCaracteresSpark");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // Carregar um arquivo de texto do sistema de arquivos
        JavaRDD<String> linhas = sc.textFile("caminho/para/seu/arquivo.txt");

        // Usar o Spark para contar os caracteres
        long totalCaracteres = linhas.map(line -> (long) line.length()).reduce((a, b) -> a + b);

        // Imprimir o resultado
        System.out.println("Total de caracteres: " + totalCaracteres);

        // Encerrar a sessão Spark
        sc.close();
    }
}