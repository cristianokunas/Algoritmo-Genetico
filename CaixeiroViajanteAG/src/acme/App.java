/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acme;

import view.Graphic;

/**
 *
 * @author Leandro
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graphic.createWindow();
        
        // laço for para criar as cidades a serem percorridas no gráfico
        for (int i = 0; i < 10; i++) {
            for (int b = 0; b < 6; b++) {
                TourManager.addCity(new City("", 10 + i * 20, 10 + b * 20));
            }
        }

        //Inicializa a população
        Population pop = new Population(20000, true);
        System.out.println("Distância inicial: " + pop.getFittest().getDistance());

        //Evolve population for x generations
        for (int i = 0; i < 300; i++) {
            pop = GA.evolvePopulation(pop);
            Graphic.setGeneration(i + 1);
        }

        // Imprime os resultados finais
        System.out.println("Distância final: " + pop.getFittest().getDistance());
        System.out.println("Solução:");
        System.out.println(pop.getFittest());

//        /* Crias as cidades que irão pertencer a cada rota */
//        City city = new City("Lisboa", 60, 200);
//        TourManager.addCity(city);
//        City city2 = new City("Santarém", 180, 200);
//        TourManager.addCity(city2);
//        City city3 = new City("Braga", 80, 180);
//        TourManager.addCity(city3);
//        City city4 = new City("Bragança", 140, 180);
//        TourManager.addCity(city4);
//        City city5 = new City("Porto", 20, 160);
//        TourManager.addCity(city5);
//        City city6 = new City("Portalegre", 100, 160);
//        TourManager.addCity(city6);
//        City city7 = new City("Viseu", 200, 160);
//        TourManager.addCity(city7);
//        City city8 = new City("Setúbal", 140, 140);
//        TourManager.addCity(city8);
//        City city9 = new City("Samora", 40, 120);
//        TourManager.addCity(city9);
//        City city10 = new City("Beja", 100, 120);
//        TourManager.addCity(city10);
//        City city11 = new City("Aveiro", 180, 100);
//        TourManager.addCity(city11);
//        City city12 = new City("Barcelos", 60, 80);
//        TourManager.addCity(city12);
//        City city13 = new City("Faro", 120, 80);
//        TourManager.addCity(city13);
//        City city14 = new City("Guimarães", 180, 60);
//        TourManager.addCity(city14);
//        City city15 = new City("Leiria", 20, 40);
//        TourManager.addCity(city15);
//        City city16 = new City("Odivelas", 100, 40);
//        TourManager.addCity(city16);
//        City city17 = new City("Sines", 200, 40);
//        TourManager.addCity(city17);
//        City city18 = new City("Tonela", 200, 20);
//        TourManager.addCity(city18);
//        City city19 = new City("Coimbra", 60, 20);
//        TourManager.addCity(city19);
//        City city20 = new City("Almada", 160, 20);
//        TourManager.addCity(city20);
//        City city21 = new City("Cascais", 150, 55);
//        TourManager.addCity(city21);
//        City city22 = new City("Almeirim", 10, 20);
//        TourManager.addCity(city22);
//        City city23 = new City("Chaves", 25, 85);
//        TourManager.addCity(city23);
//        City city24 = new City("Faro", 185, 35);
//        TourManager.addCity(city24);
//        City city25 = new City("Maia", 100, 95);
//        TourManager.addCity(city25);
        
        
//        //Cria uma população de rotas (conjunto de rotas)
//        Population pop = new Population(50, true);
//        
//        //Imprime o comprimento da melhor rota da população inicial
//        System.out.println("Distância inicial: " + (int)pop.getFittest().getDistance());
// 
//        //Evoluí a população por 200 gerações
//        for (int i = 0; i < 200; i++) {
//            pop = GA.evolvePopulation(pop);
//        }
// 
//        //Imprime o comprimento da melhor rota da população final
//        System.out.println("Distância final: " + (int)pop.getFittest().getDistance());
//        //Imprime a solução encontrada para o problema
//        System.out.println("Solução:");
//        System.out.println(pop.getFittest()); 


        
    }
}
