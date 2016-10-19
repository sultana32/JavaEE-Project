function langChange()
{
	 
	       
	       var str= $(location).attr('pathname');
	       var m = str.indexOf("/");
	      
	       m=m+1;
	       if(str.indexOf("?")>-1)
	    	   {
	    	   		var mypath1=str.slice(m,str.indexOf("?"));
	    	   		window.location='change?prev=' + mypath1;
	    	   }
	       else{
	       
			       var mypath = str.slice(m);
			       window.location = 'change?prev=' + mypath;
	       		}
			       
	}

function signoutConfirm() {
	var r=confirm("Do you want to sign out?");
    if (r)
    {
        //write redirection code
        window.location = "signout";
    }
    else
    {
        //do nothing
    }
}

function signoutConfirmGr() {
	var r=confirm("Das ist you want to sign out?");
    if (r)
    {
        //write redirection code
        window.location = "signout";
    }
    else
   {
        //do nothing
    }
}