package model._3input;

import static com.google.common.collect.ImmutableList.of;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.AbstractLogic3InputElement;
import static util.CubeElement.D;
import static util.CubeElement.ND;
import static util.CubeElement.ONE;
import static util.CubeElement.X;
import static util.CubeElement.ZERO;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class AndNot3InputElement extends AbstractLogic3InputElement {
   public AndNot3InputElement() {
      super(
            of(
                  of(ONE, ONE, ONE, ZERO),
                  of(ZERO, X, X, ONE),
                  of(X, ZERO, X, ONE),
                  of(X, X, ZERO, ONE)
            ),
            of(
                  of(ONE, ONE, ONE, ND),
                  of(ZERO, X, X, D),
                  of(X, ZERO, X, D),
                  of(X, X, ZERO, D)
            )
      );
   }
}
