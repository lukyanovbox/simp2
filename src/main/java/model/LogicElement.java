package model;

import java.util.List;
import java.util.Map;

import util.CubeElement;
import util.CubeWorker;
import util.FaultType;


public interface LogicElement extends Element {

   default List<Map<String, CubeElement>> runDAlgorithm(FaultType faultType) {
      //filter primitive failure cubes
      List<List<CubeElement>> filteredPrimitiveDFailureCubes = CubeWorker.filterByFaultType(
            this.getPrimitiveDFailureCubes(),
            faultType
      );
      //convert to map with names of inputs and itself
      List<Map<String, CubeElement>> primitiveDFailureCubesMap = CubeWorker.convertToCubeMapList(
            filteredPrimitiveDFailureCubes,
            this.getElementsNames()
      );
      //call
      return this.runDAlgorithmInternal(primitiveDFailureCubesMap, this);
   }


   default List<Map<String, CubeElement>> applyDCubes(List<Map<String, CubeElement>> cubesMaps) {
      List<List<CubeElement>> dCubes = CubeWorker.constructDCubes(this.getSingularityCubes());
      return this.applyCubesOnCubeMaps(cubesMaps, dCubes);
   }


   default List<Map<String, CubeElement>> applyCubesOnCubeMaps(List<Map<String, CubeElement>> cubesMaps,
         List<List<CubeElement>> cubesToApply) {
      List<Map<String, CubeElement>> cubesMapsToApply = CubeWorker.convertToCubeMapList(
            cubesToApply,
            this.getElementsNames()
      );
      return CubeWorker.applyCubesOnCubes(cubesMaps, cubesMapsToApply);
   }


   List<Map<String, CubeElement>> runDAlgorithmInternal(List<Map<String, CubeElement>> cubes, Element fromElement);


   List<Map<String, CubeElement>> applySingularityCubesR(List<Map<String, CubeElement>> cubes);


   List<List<CubeElement>> getPrimitiveDFailureCubes();


   List<List<CubeElement>> getSingularityCubes();


   List<String> getElementsNames();
}
