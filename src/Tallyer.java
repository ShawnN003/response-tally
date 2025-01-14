import java.util.*;
/**
 * The Tallyer class provides functionality for reading ID and topic pairs from user input,
 * and tallying the number of occurrences of each topic.
 */
public class Tallyer{
    /**
     * The main method serves as the entry point for the program. It reads pairs of IDs and topics
     * from standard input, stores them in lists, and then calculates the number of occurrences
     * of each topic. The IDs and topics are guaranteed to not include internal whitespace.
     *
     * @param args command-line arguments (not used in this implementation)
     */
    public static void main(String[] args)
    {


        List<String> ids = new ArrayList<>();
        List<String> topics = new ArrayList<>();

        // Reading input for IDs and topics
        // Assumes file is well formed into pairs
        topics.add("maps");
        topics.add("maps");
        topics.add("lists");
        topics.add("arrays");
        topics.add("loops");
        topics.add("arrays");
        topics.add("compound");

        ids.add("studentA");
        ids.add("studentB");
        ids.add("studentA");
        ids.add("studentB");
        ids.add("studentC");
        ids.add("studentC");
        ids.add("studentA");

        // Wave 1
        Map<String, Integer> topicCounts = tallyTopics(topics);
        System.out.println("Here are how many times each topic appears (unfiltered):");
        System.out.println(topicCounts);

        // Wave 2
        Map<String, Integer> topicCountsFiltered = tallyTopicsFiltered(ids, topics);
        System.out.println("Here are how many times each topic appears (filtered):");
        System.out.println(topicCountsFiltered);
    }

    /**
     * Tally the occurrences of each topic from the provided list of topics.
     * This method takes a list of topics. It returns a Map where the keys are topics
     * and the values are how many times they appear in the input.
     *
     * @param topics a list of strings representing the topics to be tallied
     * @return a map containing topics as keys and their occurrence counts as values
     */
    public static Map<String, Integer> tallyTopics(List<String> topics) {
        // WAVE 1

        Map <String, Integer> topicCounts = new HashMap<>();
        int newCount = 0;
        int currentCount = 0;
        for (String topic : topics)
        {
            topicCounts.put(topic,0);
        }

        for (String topic : topics)
        {
            currentCount = topicCounts.get(topic);
            newCount = currentCount + 1;
            topicCounts.put(topic,newCount);
        }
        return topicCounts;
    }

//    for(int i = 0; i < ids.size(); i++)
//    {
//        filteringTopics.put(ids.get(i),topics.get(i));
//        if(filteringTopics.containsKey(ids.get(i)))
//        {
//
//        }
//    }

    /**
     * Tally the occurrences of valid votes for each topic from the provided lists of IDs and topics.
     *
     * The lists are of equal length and are aligned: the id at index zero cast a vote for
     * the topic at endex 0, the id at index 1 cast a vote for the topic at index 1, etc.
     * It returns a map where each topic is associated with the number of times it appears in the input.
     * However, any user who did not enter exactly 2 topics should not have their votes counted.
     *
     * @param ids a list of strings representing IDs associated with each topic
     * @param topics a list of strings representing the topics to be tallied
     * @return a map containing topics as keys and their occurrence counts as values
     */
    public static Map<String, Integer> tallyTopicsFiltered(List<String> ids, List<String> topics)
    {
        // WAVE 2
        Map <String, Integer> idCounts = new HashMap<>();
        Map <String, Integer> filteredTopics = new HashMap<>();
        Map <String, String> testingTopics = new HashMap<>();
        int newCount = 0;
        int currentCount = 0;

        for(int i = 0; i < ids.size(); i++)
        {
            testingTopics.put(ids.get(i),topics.get(i));
            idCounts.put(ids.get(i),0);
        }
        for(int i = 0; i < ids.size(); i++)
        {
            if(ids.contains(ids.get(i)))
            {
                currentCount = idCounts.get(ids.get(i));
                newCount = currentCount + 1;
                idCounts.put(ids.get(i),newCount);
            }
        }
        for(int i = 0; i < ids.size(); i++)
        {
            System.out.println(ids.get(i));
            System.out.println(topics.get(i));
            System.out.println("*************************");
            if(idCounts.get(ids.get(i)) == 2)
            {
                if(!filteredTopics.containsKey(topics.get(i)))
                {
                    filteredTopics.put(topics.get(i),1);
                }
                else
                {
                    currentCount = filteredTopics.get(topics.get(i));
                    newCount = currentCount + 1;
                    filteredTopics.put(topics.get(i), newCount);
                }
            }
        }

        return filteredTopics;
    }
}
