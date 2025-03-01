int max_index_of_N = 0;
    //     int max_count_of_N = 0;
    //     String[] len_N = new String[27];

    //     for(int i = 1; i < 26; i++){
    //         CharacterComparator cc = new OffByN(i);

    //         // 每次循环都需要更新 in，因为每次循环都需要从头开始读取 words.txt 文件
    //         in = new In("../library-sp18/data/words.txt");

    //         int count = 0;
    //         int maxlen = 0;
    //         while (!in.isEmpty()) {
    //             String word = in.readString();
    //             if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
    //                 count++;
    //                 // System.out.println(word);
    //                 if (word.length() > maxlen) {
    //                     maxlen = word.length();
    //                     len_N[i] = word;
    //                 }
    //             }
    //         }
    //         if (count > max_count_of_N) {
    //             max_index_of_N = i;
    //             max_count_of_N = count;
    //         }
    //     }

    //     System.out.println("For " + String.valueOf(max_index_of_N) + " there are the most palindromes with the count of " + String.valueOf(max_count_of_N));
        
    //     System.out.println("The longest in OffByN:");
    //     for(int i = 1; i < 26; i++) {
    //         System.out.println("For N = " + String.valueOf(i) + " is: " + len_N[i]);    
    //     }
    // }