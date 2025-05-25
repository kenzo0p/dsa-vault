package FloodFillAlgo;
public class FloodFillAlgo { //0(m*n)

    public void helper(int [][]image , int sr , int sc  , int color , boolean vis[][] , int orgCol){
        if(sr < 0 || sc <0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgCol){
            return;
        }
        //left
        vis[sr][sc] = true;
        image[sr][sc] = color;
        helper(image, sr, sc-1, color, vis, orgCol);
        //right 
        helper(image, sr, sc+1, color, vis, orgCol);
        //up
        helper(image, sr-1, sc, color, vis, orgCol);
        //down
        helper(image, sr+1, sc, color, vis, orgCol);
    } 
    public int[][] floodFill(int [][]image , int sr , int sc  , int color){ //733
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image , sr , sc , color ,vis , image[sr][sc]);
        return image;
    }
    public static void main(String[]args){

    }
}
