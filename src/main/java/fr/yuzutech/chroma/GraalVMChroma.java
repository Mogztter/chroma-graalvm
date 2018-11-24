package fr.yuzutech.chroma;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GraalVMChroma {

  private static GraalVMChroma instance = null;
  private final Value chroma;

  private GraalVMChroma() throws IOException, URISyntaxException {
    Context context = Context.create();
    String content = readResource("chroma.min.js");
    context.eval("js", content);
    chroma = context.eval("js", "chroma");
  }

  private String readResource(String name) throws IOException, URISyntaxException {
    URL chromaResource = Thread.currentThread().getContextClassLoader().getResource(name);
    return new String(Files.readAllBytes(Paths.get(chromaResource.toURI())));
  }

  public static GraalVMChroma create() throws IOException, URISyntaxException {
    if (instance == null) {
      instance = new GraalVMChroma();
    }
    return instance;
  }

  public Value getChroma() {
    return chroma;
  }
}
