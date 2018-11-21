package model._1input;

import static com.google.common.collect.ImmutableList.of;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.AbstractLogic1InputElement;
import static util.CubeElement.D;
import static util.CubeElement.ND;
import static util.CubeElement.ONE;
import static util.CubeElement.ZERO;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class Not1InputElement extends AbstractLogic1InputElement {
   public Not1InputElement() {
      super(
            of(
                  of(ONE, ZERO),
                  of(ZERO, ONE)
            ),
            of(
                  of(ONE, ND),
                  of(ZERO, D)
            )
      );
   }
}
