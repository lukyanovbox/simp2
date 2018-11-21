package util;

import lombok.Getter;


public enum CubeElement {
   X("x "), ONE("1 "), ZERO("0 "), D("d "), ND("nd"), EMPTINESS("E ");

   @Getter
   private String representation;

   CubeElement(final String s) {
      this.representation = s;
   }
}
