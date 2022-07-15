public class Converter {
    double stepLength;
    double stepCalBern;

    Converter(double stepLengthI, double stepCalBernI){
        stepLength = stepLengthI;
        stepCalBern = stepCalBernI;
    }

    int caloriesToDistance(int stepsNum){
        return (int)(stepsNum * stepLength / 1000);
    }

    int countCalBurned(int stepsNum){
        return (int)(stepsNum * stepCalBern);
    }
}
