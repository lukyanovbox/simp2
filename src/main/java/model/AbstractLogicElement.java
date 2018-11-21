package model;

import java.util.List;

import util.CubeElement;


public abstract class AbstractLogicElement implements LogicElement {

   private String name;

   LogicElement nextElement;

   private List<List<CubeElement>> singularityCubes;

   private List<List<CubeElement>> primitiveDFailureCubes;


   public AbstractLogicElement(List<List<CubeElement>> singularityCubes, List<List<CubeElement>> primitiveDFailureCubes) {
      this.singularityCubes = singularityCubes;
      this.primitiveDFailureCubes = primitiveDFailureCubes;
   }

   @Override
   public String getName() {
      return name;
   }

   @Override
   public void setName(final String name) {
      this.name = name;
   }

   public void setNextElement(final LogicElement nextElement) {
      this.nextElement = nextElement;
   }

   @Override
   public List<List<CubeElement>> getSingularityCubes() {
      return singularityCubes;
   }

   @Override
   public List<List<CubeElement>> getPrimitiveDFailureCubes() {
      return primitiveDFailureCubes;
   }
}
