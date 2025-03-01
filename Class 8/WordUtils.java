public class WordUtils {
    public static String longest(SLList<String> list){
        int maxDex = 0;
        for(int i = 0; i < list.size(); i++){
            String longestString = list.getFirst();
            String thisString = list.get(i);
            if(thisString.length() > longestString.length()){
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }

    public static String longest(AList<String> list){
        /** Overloading is terrible for maintainence. We use Interface for that purpose. */
        int maxDex = 0;
        for(int i = 0; i < list.size(); i++){
            String longestString = list.getFirst();
            String thisString = list.get(i);
            if(thisString.length() > longestString.length()){
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }

    public static String longest(List61B<String> list){
        int maxDex = 0;
        for(int i = 0; i < list.size(); i++){
            String longestString = list.getFirst();
            String thisString = list.get(i);
            if(thisString.length() > longestString.length()){
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }



    public static void main(String[] args) {
        SLList<String> L = new SLList<>();
        L.addFirst("watching");
        L.addFirst("are");
        L.addFirst("elk");
        System.out.println(longest(L));
    }
}
