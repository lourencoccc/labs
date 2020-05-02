package com.cloudec.hbcs.hbase;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

/**
 * Created by joao_lourenco on 5/12/17.
 */
public class PocMd5 {

  public static void main(String... args){
    try{
      System.out.println("33".getBytes().length);
      for(byte b : "33".getBytes()){
        System.out.print(b);
      }
      System.out.println("\n");
      for(byte b : "34".getBytes()){
        System.out.print(b);
      }
      System.out.println("\n");
      System.out.println("34".getBytes().length);
      System.out.println("MD5HEX "+DigestUtils.md5Hex("34".getBytes()));
      System.out.println("MD5 "+DigestUtils.md5("343232"));
      System.out.println("MD5 "+DigestUtils.md5("343232"));
      System.out.println("MD5HEX "+DigestUtils.md5Hex("343232").getBytes());
      System.out.println("MD5HEX "+ new String(DigestUtils.md5Hex("343232").getBytes(), StandardCharsets.UTF_8));
      System.out.println("ca8c74fcc8727b9e6590f438e8bf8ce2".getBytes().length);
    }catch (Exception ex){
      ex.printStackTrace();
    }
  }
}
