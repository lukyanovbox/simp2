package model._2input;

import static com.google.common.collect.ImmutableList.of;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.AbstractLogic2InputElement;
import static util.CubeElement.D;
import static util.CubeElement.ND;
import static util.CubeElement.ONE;
import static util.CubeElement.ZERO;


@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class Xor2InputElement extends AbstractLogic2InputElement {
   public Xor2InputElement() {
      super(
            of(
                  of(ZERO, ZERO, ZERO),
                  of(ZERO, ONE, ONE),
                  of(ONE, ZERO, ONE),
                  of(ONE, ONE, ZERO)
            ),
            of(
                  of(ZERO, ZERO, ND),
                  of(ZERO, ONE, D),
                  of(ONE, ZERO, D),
                  of(ONE, ONE, ND)
            )
      );
   }
}
