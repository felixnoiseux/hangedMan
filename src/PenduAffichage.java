public class PenduAffichage {
    public  String getAffichage(byte partieCorps){
        switch (partieCorps){
            case 0:
                return "---------- \n" +
                        "|        | \n" +
                        "| \n" +
                        "| \n" +
                        "| \n" +
                        "|\\  \n" +
                        "| \\ ";
            case 1:
                return "---------- \n" +
                        "|        | \n" +
                        "|        o\n" +
                        "| \n" +
                        "| \n" +
                        "|\\  \n" +
                        "| \\ ";
            case 2:
                return "---------- \n" +
                        "|        | \n" +
                        "|        o\n" +
                        "|        |\n" +
                        "| \n" +
                        "|\\  \n" +
                        "| \\ ";
            case 3:
                return "---------- \n" +
                        "|        | \n" +
                        "|        o\n" +
                        "|      --|\n" +
                        "| \n" +
                        "|\\  \n" +
                        "| \\ ";
            case 4:
                return "---------- \n" +
                        "|        | \n" +
                        "|        o\n" +
                        "|      --|--\n" +
                        "| \n" +
                        "|\\  \n" +
                        "| \\ ";
            case 5:
                return "---------- \n" +
                        "|        | \n" +
                        "|        o\n" +
                        "|      --|--\n" +
                        "|       /\n" +
                        "|\\  \n" +
                        "| \\ ";
            case 6:
                return "---------- \n" +
                        "|        | \n" +
                        "|        o\n" +
                        "|      --|--\n" +
                        "|       / \\ \n" +
                        "|\\  \n" +
                        "| \\ ";
        }
        return "";
    }
}
