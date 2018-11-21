package model;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.ImmutableList.of;
import lombok.EqualsAndHashCode;
import util.CubeElement;


@EqualsAndHashCode(callSuper = true)
public class AbstractLogic1InputElement extends AbstractLogicElement {

   Element firstInput;

   public AbstractLogic1InputElement(final List<List<CubeElement>> singularityCubes,
         final List<List<CubeElement>> primitiveDFailureCubes) {
      super(singularityCubes, primitiveDFailureCubes);
   }

   @Override
   public List<Map<String, CubeElement>> runDAlgorithmInternal(List<Map<String, CubeElement>> cubes, Element fromElement) {

      List<Map<String, CubeElement>> intermediateResult;
      if (fromElement == this) {
         intermediateResult = cubes;
      }
      else {
         //dcube apply
         intermediateResult = this.applyDCubes(cubes);
      }

      if (this.nextElement != null) {
         intermediateResult = this.nextElement.runDAlgorithmInternal(intermediateResult, this);
      }

      if (fromElement.equals(this)) {
         if (this.firstInput instanceof LogicElement) {
            intermediateResult = ((LogicElement) this.firstInput).applySingularityCubesR(intermediateResult);
         }
      }

      return intermediateResult;
   }


   @Override
   public List<Map<String, CubeElement>> applySingularityCubesR(List<Map<String, CubeElement>> cubesMaps) {
      //apply singularity cubes
      List<Map<String, CubeElement>> intermediateResult = this.applyCubesOnCubeMaps(cubesMaps, this.getSingularityCubes());

      // apply
      if (this.firstInput instanceof LogicElement) {
         intermediateResult = ((LogicElement) this.firstInput).applySingularityCubesR(intermediateResult);
      }

      return intermediateResult;
   }

   @Override
   public List<String> getElementsNames() {
      return of(firstInput.getName(), this.getName());
   }

   public void setFirstInput(final Element firstInput) {
      this.firstInput = firstInput;
   }
}
