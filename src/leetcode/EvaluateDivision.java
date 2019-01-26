class Solution {
    class Tuple{
        String n;
        double v;
        double c;
        Tuple(String n, double v){
            this.n = n; this.v = v; this.c = 1;
        }
    }
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Tuple>> graph = new HashMap<>();
        double[] out = new double[queries.length];
        
        for(int i = 0; i < values.length; i++){
            String[] e = equations[i];
            
            // forward edges - normal values
            List<Tuple> forward = graph.get(e[0]);
            if(forward == null){
                forward = new LinkedList<>();
                forward.add(new Tuple(e[0], 1)); // self edges -> a / a = 1
            }
            forward.add(new Tuple(e[1], values[i]));
            graph.put(e[0], forward);
            
            // reverse edges - reciprocal values
            List<Tuple> reverse = graph.get(e[1]);
            if(reverse == null) {
                reverse = new LinkedList<>();
                reverse.add(new Tuple(e[1], 1)); // self edges -> a / a = 1
            }
            reverse.add(new Tuple(e[0], (1/values[i])));
            graph.put(e[1], reverse);
        }
        
        for(int i = 0; i < queries.length; i++){
            String from = queries[i][0];
            String to = queries[i][1];
            Set<String> visited = new HashSet<>();
            
            out[i] = dfs(graph, visited, from, to, 1.0);
        }
        return out;
    }
    
    private double dfs(Map<String, List<Tuple>> graph, Set<String> visited, String from, String to, double sofar) {
        visited.add(from);
        if(graph.containsKey(from)){
            for(Tuple t : graph.get(from)){
                t.c = t.v * sofar;
                if(t.n.equals(to))
                    return t.c;
                if(!visited.contains(t.n)){
                    double val = dfs(graph, visited, t.n, to, t.c);
                    if(val > -1.0) return val;
                }
            }
        }
        return -1.0;
    }
}