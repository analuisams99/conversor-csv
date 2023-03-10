package com.trybe.conversorcsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**Classe Conversor. */
public class Conversor {
  private static final String ARQUIVO_ENTRADA = "./entradas/";
  private static final String ARQUIVO_SAIDA = "./saidas/";
  private static final String SEPARADOR = ",";

  /**
   * Função utilizada apenas para validação da solução do desafio.
   *
   * @param args Não utilizado.
   * @throws IOException Caso ocorra algum problema ao ler os arquivos de entrada ou
   *                     gravar os arquivos de saída.
   */
  public static void main(String[] args) throws IOException {
    File pastaDeEntradas = new File(ARQUIVO_ENTRADA);
    File pastaDeSaidas = new File(ARQUIVO_SAIDA);
    new Conversor().converterPasta(pastaDeEntradas, pastaDeSaidas);
  }

  /**
   * Converte todos os arquivos CSV da pasta de entradas. Os resultados são gerados
   * na pasta de saídas, deixando os arquivos originais inalterados.
   *
   * @param pastaDeEntradas Pasta contendo os arquivos CSV gerados pela página web.
   * @param pastaDeSaidas Pasta em que serão colocados os arquivos gerados no formato
   *                      requerido pelo subsistema.
   *
   * @throws IOException Caso ocorra algum problema ao ler os arquivos de entrada ou
   *                     gravar os arquivos de saída.
   */
  public void converterPasta(File pastaDeEntradas, File pastaDeSaidas) throws IOException {
    if (!pastaDeSaidas.exists()) {
      pastaDeSaidas.mkdir();
    }
    
    File[] listaArqEntrada = pastaDeEntradas.listFiles();

    for (File arquivoEntrada : listaArqEntrada) {
      // Cria novo arquivo de saída
      File arqSaida = new File(pastaDeSaidas + File.separator + arquivoEntrada.getName());

      try (BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivoEntrada));
           BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arqSaida))) {

        formatarEescreverConteudoNoArquivoSaida(bufferedReader, bufferedWriter);
      }
    }
  }
  
  private static void formatarEescreverConteudoNoArquivoSaida(
       BufferedReader bufferedReader, BufferedWriter bufferedWriter)throws IOException {

    // Lê o conteúdo da primeira linha
    String dadosLinha = bufferedReader.readLine();
    escreverCabecalho(bufferedWriter, dadosLinha);
    
    dadosLinha = bufferedReader.readLine();

    while (dadosLinha != null) {
      String[] dadosLinhaSeparados = dadosLinha.split(SEPARADOR);

      String dataFormatada = formatarData(dadosLinhaSeparados[1]);
      String cpfFormatado = formatarCpf(dadosLinhaSeparados[3]);

      String dadosFormatados = dadosLinhaSeparados[0].toUpperCase() 
          + "," + dataFormatada + "," + dadosLinhaSeparados[2] + "," + cpfFormatado;

      bufferedWriter.write(dadosFormatados);
      bufferedWriter.newLine();
      bufferedWriter.flush();

      dadosLinha = bufferedReader.readLine();
    }
  }

  private static void escreverCabecalho(BufferedWriter bufferedWriter, String dadosLinha) 
      throws IOException {
    // Escreve conteudo do cabeçalho e cria uma nova linha
    bufferedWriter.write(dadosLinha);
    bufferedWriter.newLine();

    // Força a escrita de todos os dados armazenados no buffer
    bufferedWriter.flush();
  }
  
  private static String formatarData(String dataBr) {
    String[] data = dataBr.split("/");
    return String.format("%s-%s-%s", data[2], data[1], data[0]);
  }
  
  private static String formatarCpf(String cpf) {
    return cpf.substring(0, 3) + "." 
        + cpf.substring(3, 6) + "." 
        + cpf.substring(6, 9) + "-"
        + cpf.substring(9, 11);
  }  
}
