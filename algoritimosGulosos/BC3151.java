package algoritimosGulosos;

import java.util.Scanner;

public class BC3151 {

    public static int encontraMaiorDensidade(double[] vetGostosura, double[] vetVolume) {
        double maiorDensidade = 0;
        int maiorPosicao = -1;
        for (int i = 0; i < vetGostosura.length; i++) {
            if (vetGostosura[i] >= 0) {
                double densidade = vetGostosura[i] / vetVolume[i];
                if (densidade > maiorDensidade) {
                    maiorDensidade = densidade;
                    maiorPosicao = i;
                }
            }
        }
        return maiorPosicao;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int casosTeste = scanner.nextInt();

        while (casosTeste > 0) {
            int numIorgutes = scanner.nextInt();
            double volumeTotalRest = scanner.nextDouble();
            double[] vetGostosura = new double[numIorgutes];
            double[] vetVolume = new double[numIorgutes];
            double gostosuraTot = 0;

            for (int i = 0; i < numIorgutes; i++) {
                vetGostosura[i] = scanner.nextDouble();
                vetVolume[i] = scanner.nextDouble();
            }

            while (volumeTotalRest > 0) {
                int posiMaiorDensidade = encontraMaiorDensidade(vetGostosura, vetVolume);
                if (posiMaiorDensidade == -1) break;

                if (vetVolume[posiMaiorDensidade] <= volumeTotalRest) {
                    volumeTotalRest -= vetVolume[posiMaiorDensidade];
                    gostosuraTot += vetGostosura[posiMaiorDensidade];
                    vetGostosura[posiMaiorDensidade] = -1;
                } else {
                    gostosuraTot += (vetGostosura[posiMaiorDensidade] / vetVolume[posiMaiorDensidade]) * volumeTotalRest;
                    volumeTotalRest = 0;
                }
            }

            System.out.printf("%.2f%n", gostosuraTot);
            casosTeste--;
        }
    }
}