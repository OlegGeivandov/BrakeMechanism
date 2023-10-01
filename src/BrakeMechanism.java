import java.util.ArrayList;

public class BrakeMechanism {
    ArrayList<Integer> firstBrakePad;
    ArrayList<Integer> secondBrakePad;
    int minimumLegalBrakeLength;
    int min, tempMin;

    public BrakeMechanism(ArrayList<Integer> firstBrakePad, ArrayList<Integer> secondBrakePad) {
        if (firstBrakePad.size() >= secondBrakePad.size()) {
            this.firstBrakePad = firstBrakePad;
            this.secondBrakePad = secondBrakePad;
        }
        else {
            this.firstBrakePad = secondBrakePad;
            this.secondBrakePad = firstBrakePad;
        }
        this.minimumLegalBrakeLength = firstBrakePad.size() + secondBrakePad.size();
        this.min = minimumLegalBrakeLength;
        this.tempMin = minimumLegalBrakeLength;
    }

    void calculateLegalBrakeLength(){
        firstPartCalculate();
        secondPartCalculate();
    }

    private void firstPartCalculate() {
        for (int i = 0; i < firstBrakePad.size(); i++) {
            boolean isGoodProfile = true;
            for (int j = secondBrakePad.size()-1, k=i; j>=0 && k>=0 ; j--, k--) {
                if (firstBrakePad.get(k) + secondBrakePad.get(j) > 3) isGoodProfile = false;
            }
            if (isGoodProfile && i < secondBrakePad.size()) tempMin = firstBrakePad.size() + secondBrakePad.size() - 1 - i;
            if (isGoodProfile && i >= secondBrakePad.size()) tempMin = firstBrakePad.size();
            if (tempMin < min) min = tempMin;
        }
        if (min < minimumLegalBrakeLength) minimumLegalBrakeLength = min;
    }

    private void secondPartCalculate() {
        for (int i = firstBrakePad.size()-secondBrakePad.size()+1; i < firstBrakePad.size(); i++) {
            boolean isGoodProfile = true;
            for (int j = 0, k=i; j<firstBrakePad.size()-i; j++, k++) {
                if (firstBrakePad.get(k) + secondBrakePad.get(j) > 3) isGoodProfile = false;
            }
            if (isGoodProfile) tempMin = secondBrakePad.size() + i;
            if (tempMin < min) min = tempMin;
        }
        if (min < minimumLegalBrakeLength) minimumLegalBrakeLength = min;
    }
}
