package com.acme.basic;

import java.util.Base64;
import org.apache.http.client.methods.HttpPost;

public class HelloWorld {

  void sayHello() {
    System.out.println("Hello World!");
  }

  void notCovered() {
    System.out.println("This method is not covered by unit tests");
  }

  boolean myBadFunction() {
    String name = "hello";

    if ( name == "world" ) {
      return true;
    }

    return true;
  }

  void anotherBadFunction() {
    java.util.regex.Pattern.compile("(a+)+").matcher(
    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
    "aaaaaaaaaaaaaaa!").matches(); // Sensitive

    java.util.regex.Pattern.compile("(h|h|ih(((i|a|c|c|a|i|i|j|b|a|i|b|a|a|j))+h)ahbfhba|c|i)*").matcher(
    "hchcchicihcchciiicichhcichcihcchiihichiciiiihhcchi"+
    "cchhcihchcihiihciichhccciccichcichiihcchcihhicchcciicchcccihiiihhihihihi"+
    "chicihhcciccchihhhcchichchciihiicihciihcccciciccicciiiiiiiiicihhhiiiihchccch"+
    "chhhhiiihchihcccchhhiiiiiiiicicichicihcciciihichhhhchihciiihhiccccccciciihh"+
    "ichiccchhicchicihihccichicciihcichccihhiciccccccccichhhhihihhcchchihih"+
    "iihhihihihicichihiiiihhhhihhhchhichiicihhiiiiihchccccchichci").matches(); // Sensitive
  }

  void login(String url) {
    String original = "login:passwd";
    byte[] bytes = original.getBytes();
    String encoding = Base64.getEncoder().encodeToString(bytes);

    org.apache.http.client.methods.HttpPost httppost = new HttpPost(url);
    httppost.setHeader("Authorization", "Basic " + encoding);  // Noncompliant
  }
}
