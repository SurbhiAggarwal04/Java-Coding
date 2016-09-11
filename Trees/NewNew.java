/*  var orderOfBrackets={ '(':')' , '{':'}' , '[':']'};
    var stack=[];
    var result=[];
    for(var i=0;i<values.length;i++)
        {
            var input=values[i];
            
            var inputResult="YES";
            for(var j=0;j<input.length;j++)
                {
                    if(input.charAt(j)=='{' || input.charAt(j)=='(' || input.charAt(j)=='[')
                        stack.push(input.charAt(j));
                    else
                        {
                            
                            if(input.charAt(j)==')' || input.charAt(j)=='}' || input.charAt(j)==']')
                                {
                                    if(stack.length==0)
                                      {
                                         inputResult="NO";
                                           break;
                                
                                       }
                                    else
                                        {
                                             if(input.charAt(j)!=orderOfBrackets[stack[stack.length-1]])
                                                 {
                                                      inputResult="NO";
                                                    
                                                      break;
                                                 }
                                            else stack.pop();
                                        }
                                }
                            
                            
                        
                }
            
                }
         // if(inputResult!="NO")inputResult="YES";
           // if(stack.length>0)inputResult="NO";
            //else inputResult="YES";
           if(stack.length==0 && inputResult!="NO")inputResult="YES";
            else inputResult="NO";
            result.push(inputResult);
        }
    return result;
*/