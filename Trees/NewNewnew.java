/*function test(values) {
    var result=[];
  for(var i=0;i<values.length;i++)
     { 
      if(processInput(values[i]))result.push("YES");
         else result.push("NO");
     }
    return result;
}
function processInput(input)
{
    var stack=[];
   for(var i =0;i<input.length;i++)
   {
      if(input[i] == '(' || input[i] == '{' || input[i] == '[')
        stack.push(input[i]);
      else if(input[i] == ')' || input[i] == '}' || input[i] == ']')
      {
        if(stack.length==0 || !isBalanced(stack[stack.length-1],input[i]))
           return false;
        else
           stack.pop();
      }
   }
   if(stack.length==0)
      return true;
   else
      return false;
}

function isBalanced(character1,character2)
{
   if(character1 == '(' && character2 == ')')
     return true;
   else if(character1 == '{' && character2 == '}')
     return true;
   else if(character1 == '[' && character2 == ']')
     return true;
   else
     return false;
}*/