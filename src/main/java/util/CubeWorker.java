package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkState;
import static util.CubeElement.D;
import static util.CubeElement.EMPTINESS;
import static util.CubeElement.ND;
import static util.CubeElement.ONE;
import static util.CubeElement.X;
import static util.CubeElement.ZERO;


public class CubeWorker {


   public static List<List<CubeElement>> filterByFaultType(List<List<CubeElement>> originalFaultList, FaultType faultType) {

      switch (faultType) {
         case CONSTANT_ONE:
            return originalFaultList.stream()
                  .filter(cube -> cube.get(cube.size() - 1) == CubeElement.ND)
                  .collect(Collectors.toList());
         case CONSTANT_ZERO:
            return originalFaultList.stream()
                  .filter(cube -> cube.get(cube.size() - 1) == CubeElement.D)
                  .collect(Collectors.toList());
         default:
            throw new IllegalArgumentException("Unknown FaultType");
      }
   }


   public static List<Map<String, CubeElement>> convertToCubeMapList(List<List<CubeElement>> cubes, List<String> elementNames) {
      List<Map<String, CubeElement>> result = new ArrayList<>();

      for (List<CubeElement> cube : cubes) {
         checkState(cube.size() == elementNames.size(),
               "Wrong count of elements in names or in cubes");

         Map<String, CubeElement> cubeMap = new HashMap<>();
         for (int i = 0; i < cube.size(); i++) {
            cubeMap.put(elementNames.get(i), cube.get(i));
         }

         result.add(cubeMap);
      }

      return result;
   }

   public static List<List<CubeElement>> constructDCubes(final List<List<CubeElement>> singularityCubes) {

      List<List<CubeElement>> dCubes = new ArrayList<>();

      for (List<CubeElement> singularityCube : singularityCubes) {
         for (List<CubeElement> singularityCubeToCompare : singularityCubes) {
            if (singularityCube != singularityCubeToCompare
                  && singularityCube.get(singularityCube.size() - 1) != singularityCubeToCompare.get(
                  singularityCubeToCompare.size() - 1)) {
               List<CubeElement> dCube = new ArrayList<>();
               for (int i = 0; i < singularityCube.size(); i++) {
                  CubeElement dElement = singularityToDElement(singularityCube.get(i), singularityCubeToCompare.get(i));
                  dCube.add(dElement);
               }
               dCubes.add(dCube);
            }
         }
      }

      return dCubes;
   }

   public static List<Map<String, CubeElement>> applyCubesOnCubes(
         final List<Map<String, CubeElement>> cubes,
         final List<Map<String, CubeElement>> cubesToApply) {

      List<Map<String, CubeElement>> result = new ArrayList<>();

      for (Map<String, CubeElement> cube : cubes) {
         for (Map<String, CubeElement> cubeToApply : cubesToApply) {

            Map<String, CubeElement> candidate = new HashMap<>(cube);

            cubeToApply.forEach((key, value) -> candidate.merge(key, value, mergeDElements));

            if(candidate.values().stream().noneMatch(el -> el == CubeElement.EMPTINESS)){
               result.add(candidate);
            }
         }
      }

      return result;
   }


   private static CubeElement singularityToDElement(CubeElement el1, CubeElement el2) {
      if (el1 == ZERO && el2 == ZERO) {
         return ZERO;
      }
      else if (el1 == ZERO && el2 == X) {
         return ZERO;
      }
      else if (el1 == X && el2 == ZERO) {
         return ZERO;
      }
      else if (el1 == X && el2 == X) {
         return X;
      }
      else if (el1 == ONE && el2 == ONE) {
         return ONE;
      }
      else if (el1 == ONE && el2 == X) {
         return ONE;
      }
      else if (el1 == X && el2 == ONE) {
         return ONE;
      }
      else if (el1 == ONE && el2 == ZERO) {
         return D;
      }
      else if (el1 == ZERO && el2 == ONE) {
         return ND;
      }
      else {
         throw new IllegalArgumentException("wrong conditions");
      }
   }

   private static BiFunction<CubeElement, CubeElement, CubeElement> mergeDElements = (v1, v2) -> {
      if (v1 == v2 || v2 == X) {
         return v1;
      }
      else if (v1 == X) {
         return v2;
      }
      else {
         return EMPTINESS;
      }
   };
}
