function validate()
{
	var errorflag = 0;
	var contactbox = document.getElementById("contactbox");
	var success = document.getElementById("success");
	var spam = document.getElementById("robot");
	var spam_error = document.getElementById("robot_error");
	if (spam.value == "7")
	{

		spam_error.style.display = "none";
		errorflag = 0;
	
	}
	else
	{
		spam_error.style.display = "block";
		errorflag = 1;
	}	

	if (errorflag == 0)
	{
		document.forms("contact").submit();
				contactbox.style.display = "none";
		success.style.dsplay = "block";
	}
	else
	{
		
	}
}
	
	