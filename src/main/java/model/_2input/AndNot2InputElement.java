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
public class AndNot2InputElement extends AbstractLogic2InputElement {

   public AndNot2InputElement() {
      super(
            of(
                  of(ONE, ONE, ZERO),
                  of(ZERO, X, ONE),
                  of(X, ZERO, ONE)
            ),
            of(
                  of(ONE, ONE, ND),
                  of(ZERO, X, D),
                  of(X, ZERO, D)
            )
      );
   }
}
