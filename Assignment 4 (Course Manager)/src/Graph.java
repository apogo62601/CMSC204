import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road>{

	final int NoEdge = Integer.MAX_VALUE;
	final int NoPath = Integer.MAX_VALUE;
	
	private ArrayList<String> shortestPath = new ArrayList<>();
	private Set<Town> towns = new HashSet<>();
	private Set<Road> roads = new HashSet<>();
	private Town destination;
    private int endTown;
    

	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		
		Road road = null;

        for (Road r : roads) {
            if (r.contains(sourceVertex) && r.contains(destinationVertex)){
                road = r;
           }
        }

        return road;
	}


	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
	    if(sourceVertex == null || destinationVertex == null)
	    	throw new NullPointerException();
	    
		Road road = new Road(sourceVertex, destinationVertex, weight, description);
		roads.add(road);
		return road;
	}


	public boolean addVertex(Town v) {
		if(v == null)
			throw new NullPointerException();
		if(!towns.contains(v)) {
		towns.add(v);
		return true;
		}
		else return false;
	}


	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		
		for(Road temp : roads) {
			if(temp.contains(sourceVertex) && temp.contains(destinationVertex))
				return true;
		}
		return false;
	}


	public boolean containsVertex(Town v) {
		for(Town temp : towns) {
			if(temp.getName().equals(v.getName()))
				return true;
		}
		return false;
	}
 

	public Set<Road> edgeSet() {
		
		return roads;
	}


	public Set<Road> edgesOf(Town vertex) {
		Set<Road> temp = new HashSet<>();
				for(Road r : roads) {
					if(r.contains(vertex)) 
						temp.add(r);
				}
		return temp;
	}


	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Set<Road> temp = new HashSet<>();
		Road road = null;
		for(Road r : roads) {
			if(r.contains(destinationVertex)&& r.contains(sourceVertex) 
					&&(weight >-1) && description !=null)
				road = r;
		}
		if (roads.remove(road))
			return road;
		else return null;
	}


	public boolean removeVertex(Town v) {
		
		return towns.remove(v);
	}
	
	
	public Set<Town> vertexSet() {
		
		return towns;
	}

	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		
      
		     destination = destinationVertex;
	        dijkstraShortestPath(sourceVertex);

	        String sPath = "";

	        int totalMi = 0;

	        for (int i = 0; i < shortestPath.size() - 1; i++) {
               
	            Town source = new Town(shortestPath.get(i));
	            Town dest = new Town(shortestPath.get(i + 1));
	            Road road = getEdge(source, dest);
              
             
              
	            totalMi += road.getWeight();

	            sPath += source + " via " + road.getName() + " to " + dest 

	                    + " " + road.getWeight() + " mi;";
              

	        }

	        shortestPath.clear();

	        for (String temp : sPath.split(";")) {

	            shortestPath.add(temp);

	        }

	        shortestPath.add("Total mi: " + totalMi + " mi");

	        return shortestPath;
	}

    

	    public void dijkstraShortestPath(Town sourceVertex) {

	        shortestPath.clear();
	        Town[] allTowns = new Town[towns.size()];
	        
	        int index = 0;
	        
	        for (Town t : towns) {

	            allTowns[index] = new Town(t);
	            index++;
	        }        

	        int[][] adjacencyMatrix = new int[towns.size()][towns.size()];       

	        for (int i = 0; i < adjacencyMatrix.length; i++) {

	            for (int j = 0; j < adjacencyMatrix[i].length; j++) {

	                if (i == j || !containsEdge(allTowns[i], allTowns[j])) {

	                    adjacencyMatrix[i][j] = 0;

	                } else {

	                    int weight = getEdge(allTowns[i], allTowns[j]).getWeight();
	                    adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = weight;

	                }
	            }
	        }
	        
	        int startTown = 0;
	        for (Town t : allTowns) {

	            if (!t.equals(sourceVertex)) {

	                startTown++;

	            } else {

	                break;

	            }

	        }

	        endTown = 0;

	        for (Town t : allTowns) {

	            if (!t.equals(destination)) {

	                endTown++;

	            } else {

	                break;

	            }
	        }

	        int numTowns = adjacencyMatrix[0].length; 
	        int[] smallestWeights = new int[numTowns];

	        boolean[] added = new boolean[numTowns];

	        for (int townIndex = 0; townIndex < numTowns; townIndex++) {

	            smallestWeights[townIndex] = NoEdge;
	            added[townIndex] = false;

	        }
	        smallestWeights[startTown] = 0;
	        int[] minLengthsPath = new int[numTowns];
	        minLengthsPath[startTown] = -1;

	        

	        for (int i = 1; i < numTowns; i++) {

	            int nearestTown = -1;

	            int smallestWeight = NoEdge;

	            for (int townIndex = 0; townIndex < numTowns; townIndex++) {

	                if (!added[townIndex] && 

	                        smallestWeights[townIndex] < smallestWeight) {

	                    nearestTown = townIndex;

	                    smallestWeight = smallestWeights[townIndex];

	                }

	            }

	            added[nearestTown] = true;

	            for (int townIndex = 0; townIndex < numTowns; townIndex++) {

	                int roadDist = adjacencyMatrix[nearestTown][townIndex]; 

	                if (roadDist > 0 && 

	                        ((smallestWeight + roadDist) < smallestWeights[townIndex])) {

	                    minLengthsPath[townIndex] = nearestTown;

	                    smallestWeights[townIndex] = smallestWeight + roadDist;
	                }
	            }           
	        }
	      addToPathArrayList(endTown, minLengthsPath); 

	    }

	 private void addToPathArrayList(int sourceVertex, int[] minLengthsPath) {

	        

	        if (sourceVertex == -1) { 
	            return; 

	        } 

	        addToPathArrayList(minLengthsPath[sourceVertex], minLengthsPath); 

	        int townIndex = 0;

	        for (Town t : towns) {

	            if (townIndex == sourceVertex) {

	                shortestPath.add(t.getName()); 

	            }

	            townIndex++;

	        }

	    } 


}