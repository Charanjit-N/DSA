class LCM735AsteroidCollision {
    // TC->O(n) , SC->O(n)+O(n)  {one for stack and other O(n) to return the answer not used to solve the problem}
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<asteroids.length;i++)
        {
            if(stack.isEmpty() || asteroids[i]>0)
            {
                stack.push(asteroids[i]);
            }
            else
            {
                while(!stack.isEmpty())
                {
                    int top = stack.peek();
                    if(top<0) {stack.push(asteroids[i]); break;}
                    else
                    {
                        int absVal = Math.abs(asteroids[i]);
                        if(absVal == top) {stack.pop();break;}
                        else if(absVal < top) {break;}
                        else 
                        {
                            stack.pop();
                            if(stack.isEmpty()) { stack.push(asteroids[i]); break;}
                        }
                    }

                }
                
            }
        }
        int[] resArr =  new int[stack.size()];
        for(int i=resArr.length -1;i>=0;i--)
        {
            resArr[i] = stack.pop();
        }
        return resArr;
    }
}