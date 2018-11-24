package fr.yuzutech.chroma;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ChromaTest {

  @Test
  public void should_return_hex_string_of_pink_darken_saturate_color() {
    assertThat(Chroma.create("pink").darken().saturate(2).hex()).isEqualTo("#ff6d93");
  }

  @Test
  public void should_return_rgba_of_orange_color() {
    assertThat(Chroma.create("orange").rgba()).isEqualTo(Arrays.asList(255, 165, 0, 1));
  }
}
