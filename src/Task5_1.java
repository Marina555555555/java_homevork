import java.util.*;

public class Task5_1 {
    public static void main(String[] args) {
        String[] genres = {"Rock", "Blues", "Classic", "Rap", "RnB"};
        Map<String, Map<String, Integer>> songsByGenres = new HashMap<>();
        Map<String, String[]> genresByPlaylist = new HashMap<>();
        genresByPlaylist.put("Relax", new String[]{"Blues", "Classic"});
        genresByPlaylist.put("Work", new String[]{"Classic", "RnB"});
        genresByPlaylist.put("Gym", new String[]{"Rock", "Rap", "RnB"});
        

        for (int i = 0; i < genres.length; i++) {
            Map<String, Integer> songs = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                songs.put(genStr(), (int) (Math.random() * 1001) + 1);
            }
            songsByGenres.put(genres[i], songs);

        }
        System.out.println("Жанры");
        System.out.println(Arrays.toString(genres));
        System.out.println("Песни по жанрам");
        System.out.println(songsByGenres);
        System.out.println("Плейлисты");
        for (Map.Entry<String, String[]> entry : genresByPlaylist.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            System.out.println(Arrays.toString(entry.getValue()));
        }   

        System.out.println("Песни из плейлистов");
        for (String playlistName : genresByPlaylist.keySet()) {
            System.out.println(playlistName);
            List<Map.Entry<String, Integer>> playlist = genPlaylist(songsByGenres, genresByPlaylist, playlistName);
            System.out.println(playlist);
            System.out.println("В случайном порядке");
            System.out.println(shufflePlaylist(playlist));
        }

    }

    public static String genStr () {
        int size = (int) (Math.random() * 10) + 5;
        String genStr = "";
        for (int i = 0; i < size; i++) {
            genStr = genStr + (char)((Math.random() * 26) + 97);
        }
        return genStr;
    }

    public static List<Map.Entry<String, Integer>> genPlaylist(Map<String, Map<String, Integer>> songsByGenres, Map<String, String[]> genresByPlaylist, String playlist) {
        Map <String, Integer> songs = new HashMap<>();
        String[] genres = genresByPlaylist.get(playlist);
        // Считаем равные пропорции
        Integer songsPerGenreCount = 10 / genres.length;
        // Последний жанр будет иметь дополнительную песню (остаток)
        Integer lastGenreSongsAdditionalCount = 10 - songsPerGenreCount * genres.length;

        for (int i = 0; i < genres.length; i++) {
            Integer genreSongsCount = 0;
            
            
            // Считаем количество песен в жанре добавляя остаток для последнего жанра
            int count = songsPerGenreCount;
            if (i == genres.length - 1) {
                count = count + lastGenreSongsAdditionalCount;
            }

            List<Map.Entry<String, Integer>> sortedSongsFromGenre = sortByValue(songsByGenres.get(genres[i]));
            // Берем первые count песен из жанра
            for (int j = 0; j < count; j++) {
                songs.put(sortedSongsFromGenre.get(j).getKey(), sortedSongsFromGenre.get(j).getValue());
                genreSongsCount++;
            }
        }
        
        // Сортируем получившийся плейлист
        List<Map.Entry<String, Integer>> sortedSongs = sortByValue(songs);

        return sortedSongs;
    }

    public static List<Map.Entry<String, Integer>> shufflePlaylist(List<Map.Entry<String, Integer>> playlist) {
        Collections.shuffle(playlist);

        return playlist;
    }

    // Функция для сортировки HashMap по значению в порядке убывания, возвращающая List
    // Частично взято отсюда https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
    public static List<Map.Entry<String, Integer>>sortByValue(Map<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list =
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
         
        return list;
    }
}