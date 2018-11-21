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
public class OrNot2InputElement extends AbstractLogic2InputElement {


   public OrNot2InputElement() {
      super(
            of(
                  of(ZERO, ZERO, ONE),
                  of(ONE, X, ZERO),
                  of(X, ONE, ZERO)
            ),
            of(
                  of(ZERO, ZERO, D),
                  of(ONE, X, ND),
                  of(X, ONE, ND)
            )
      );
   }
}
