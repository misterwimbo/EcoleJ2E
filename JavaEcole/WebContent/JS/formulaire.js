function verifform()
  {
   if(document.formulaire.nom.value == "")
    {
     alert("Veuillez entrer un nom !");
     document.formulaire.nom.focus();
  
     return false;
    }
   
   if(document.formulaire.prenom.value == "")
   {
    alert("Veuillez entrer un prenom !");
    document.formulaire.prenom.focus();
 
    return false;
   }
   
   if(document.formulaire.age.value == "")
   {
    alert("Veuillez entrer une date de naissance !");
    document.formulaire.age.focus();
 
    return false;
   }
   
   if(document.formulaire.adresse.value == "")
   {
    alert("Veuillez entrer une adresse !");
    document.formulaire.adresse.focus();
 
    return false;
   }
   
   if(document.formulaire.prevnom.value == "")
   {
    alert("Veuillez entrer un nom pour la personne a prevenir !");
    document.formulaire.prevnom.focus();
 
    return false;
   }
   
   if(document.formulaire.prevprenom.value == "")
   {
    alert("Veuillez entrer un prenom pour la personne a prevenir !");
    document.formulaire.prevprenom.focus();
 
    return false;
   }
   
   if(document.formulaire.prevtel.value == "")
   {
    alert("Veuillez entrer un numero de telephone pour la personne a prevenir !");
    document.formulaire.prevtel.focus();
 
    return false;
   }
   
   
   
 /*  var date_pas_sure = document.getElementsByName('age').value;
   var format = /^(\d{1,2}\/){2}\d{4}$/;
   if(!format.test(date_pas_sure)){
	   alert('Date non valable !')
	   return false;
   }
   else{
       var date_temp = date_pas_sure.split('/');
       date_temp[1] -=1;        // On rectifie le mois !!!
       var ma_date = new Date();
       ma_date.setFullYear(date_temp[2]);
       ma_date.setMonth(date_temp[1]);
       ma_date.setDate(date_temp[0]);
       if(ma_date.getFullYear()==date_temp[2] && ma_date.getMonth()==date_temp[1] && ma_date.getDate()==date_temp[0]){
           alert('Date valable !');
       }
       else{
           alert('Date non valable !');
           return false;
       }
   }  j'arrive pas à le faire fonctionner*/
   
   
  }