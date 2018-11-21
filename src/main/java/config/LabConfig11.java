package config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.LogicElement;
import model.XElement;
import model._1input.Not1InputElement;
import model._2input.And2InputElement;
import model._2input.AndNot2InputElement;
import model._2input.OrNot2InputElement;
import model._2input.Xor2InputElement;
import model._3input.AndNot3InputElement;
import util.CubeElement;
import util.FaultType;


public class LabConfig11 {

   private List<LogicElement> scheme = new ArrayList<>();

   public LabConfig11() {
      XElement x1 = XElement.builder().name("x1").build();
      XElement x2 = XElement.builder().name("x2").build();
      XElement x3 = XElement.builder().name("x3").build();
      XElement x4 = XElement.builder().name("x4").build();
      XElement x5 = XElement.builder().name("x5").build();
      XElement x6 = XElement.builder().name("x6").build();
      XElement x7 = XElement.builder().name("x7").build();


      AndNot2InputElement F1 = new AndNot2InputElement();
      F1.setName("F1");
      F1.setFirstInput(x1);
      F1.setSecondInput(x2);

      Not1InputElement F2 = new Not1InputElement();
      F2.setName("F2");
      F2.setFirstInput(x3);

      OrNot2InputElement F3 = new OrNot2InputElement();
      F3.setName("F3");
      F3.setFirstInput(x5);
      F3.setSecondInput(x6);

      AndNot3InputElement F4 = new AndNot3InputElement();
      F4.setName("F4");
      F4.setFirstInput(x4);
      F4.setSecondInput(F3);
      F4.setThirdInput(x7);

      Xor2InputElement F5 = new Xor2InputElement();
      F5.setName("F5");
      F5.setFirstInput(F2);
      F5.setSecondInput(F4);

      And2InputElement F6 = new And2InputElement();
      F6.setName("F6");
      F6.setFirstInput(F1);
      F6.setSecondInput(F5);

      F1.setNextElement(F6);
      F2.setNextElement(F5);
      F3.setNextElement(F4);
      F4.setNextElement(F5);
      F5.setNextElement(F6);

      scheme.add(F1);
      scheme.add(F2);
      scheme.add(F3);
      scheme.add(F4);
      scheme.add(F5);
      scheme.add(F6);
   }


   public void printAll() {
      for (LogicElement element : scheme) {
         System.out.println("#####################################################");
         Arrays.stream(FaultType.values()).forEach(ft -> {

            System.out.println(String.format("Element: %s  Fault type: %s", element.getName(), ft));
            System.out.println("-----------------------------------------------------------------");

            List<Map<String, CubeElement>> resultElementMaps = element.runDAlgorithm(ft);

            System.out.println(resultElementMaps.get(0).keySet().stream().sorted().collect(Collectors.joining(" | ")));

            for (Map<String, CubeElement> resultElementMap : resultElementMaps) {
               System.out.println(resultElementMap.keySet().stream().sorted()
                     .map(resultElementMap::get)
                     .map(CubeElement::getRepresentation)
                     .collect(Collectors.joining(" | ")));
            }

            System.out.println("-----------------------------------------------------------------");
         });
         System.out.println("#####################################################");





      }
   }
}
