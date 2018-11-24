package fr.yuzutech.chroma;

import org.graalvm.polyglot.Value;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface Chroma {

  Chroma darken();

  Chroma saturate(int value);

  String hex();

  List<Integer> rgba();

  static Chroma create(String color) {
    try {
      Value chroma = GraalVMChroma.create().getChroma();
      Value instance = chroma.newInstance(color);
      return new ChromaInstance(instance);
    } catch (IOException | URISyntaxException e) {
      throw new RuntimeException("Unable to instantiate Chroma");
    }
  }
}
