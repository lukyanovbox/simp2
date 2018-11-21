package model._2input;

import static com.google.common.collect.ImmutableList.of;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.AbstractLogic2InputElement;
import static util.CubeElement.D;
import static util.CubeElement.ND;
import static util.CubeElement.ONE;
import static util.CubeElement.X;
import static util.CubeElement.ZERO;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class And2InputElement extends AbstractLogic2InputElement {
   public And2InputElement() {
      super(
            of(
                  of(ONE, ONE, ONE),
                  of(ZERO, X, ZERO),
                  of(X, ZERO, ZERO)
            ),
            of(
                  of(ONE, ONE, D),
                  of(ZERO, X, ND),
                  of(X, ZERO, ND)
            )
      );
   }
}
