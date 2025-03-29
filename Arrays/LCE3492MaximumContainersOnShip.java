//TC->O(1), SC->O(1)
class LCE3492MaximumContainersOnShip {
    public int maxContainers(int n, int w, int maxWeight) {
        return (n*n*w)<maxWeight ?  n*n : maxWeight/w;
    }
}