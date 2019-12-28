/**
 * @author : ASHLIN ABRAHAM
 * @date : 17.04.2019
 * 
 */
var stateArray = new Array('Andhra Pradesh','Arunachal Pradesh','Assam','Bihar','Chhattisgarh','Goa','Gujarat','Haryana','Himachal Pradesh','Jammu and Kashmir','Jharkhand','Karnataka','Kerala','Madhya Pradesh','Maharashtra','Manipur','Meghalaya','Mizoram','Nagaland','Odisha','Punjab','Rajasthan','Sikkim','Tamil Nadu','Telangana','Tripura','Uttar Pradesh','Uttarakhand','West Bengal');
var districtArray = new Array('Kasaragod', 'Kannur', 'Wayanad', 'Kozhikode', 'Malappuram','Palakkad', 'Thrissur', 'Ernakulam','Idukki','Kottayam', 'Alappuzha', 'Pathanamthitta', 'Kollam', 'Thiruvananthapuram');
$('#state').autocomplete({ 
            lookupLimit: 5,  
            source : stateArray,
            onSelect: function (suggestion) {
                        $('#state').val(suggestion.data);
                        }
              });
$('#editstate').autocomplete({ 
    lookupLimit: 5,  
    source : stateArray,
    onSelect: function (suggestion) {
                $('#editstate').val(suggestion.data);
                }
      });
        

/*$('#cityDistrict').autocomplete({ 
    lookupLimit: 5,  
    source : districtArray,
    onSelect: function (suggestion) {
                $('#cityDistrict').val(suggestion.data);
                }
      });

$('#editcityDistrict').autocomplete({ 
    lookupLimit: 5,  
    source : districtArray,
    onSelect: function (suggestion) {
                $('#editcityDistrict').val(suggestion.data);
                }
      });*/