def items = [25, 64, 22, 46, 20, 65, 90, 66, 48, 98]
def i = 1
while(i < items.size()){
   print "$i-"
   def auxListLeft =[]
   def auxListRight =[]
   def itemsSliced= items.collate(i)
   print "itemsSliced: $itemsSliced"
   def finalList =[]
   for( it in itemsSliced){
     def auxList = it.collate(Math.ceil(i/2) as Integer)
     if(auxList.size() < 2){
        finalList += it
        print "entro ${auxList.size()} $auxList"
        continue 
    }
    auxListLeft = auxList[0]
    auxListRight = auxList[1]
    for(z in 0..i-1){
        if(auxListLeft.size() == 0 && auxListRight.size() == 0){
            break
        }
        if(auxListLeft.size() == 0){
            finalList += auxListRight[0]
            auxListRight.remove(0)
        }else if(auxListRight.size() == 0){
            finalList += auxListLeft[0]
            auxListLeft.remove(0)
        }
        else if(auxListLeft[0] > auxListRight[0]){
            finalList += auxListRight[0]
            auxListRight.remove(0)
            }else{
                finalList+= auxListLeft[0]
                auxListLeft.remove(0)
            }
        }
     print "finalList $finalList"
    }
    items = finalList.flatten()
    i = i*2
}

if(i != items.size()){
   print i
   def finalList =[]
   def itemsSliced= items.collate(i)
   for( it in itemsSliced){
     def auxList = it.collate(Math.ceil(i/2) as Integer)
     if(auxList.size() < 2){
        finalList += it
        continue 
    }
    auxListLeft = auxList[0]
    auxListRight = auxList[1]
    for(z in 0..items.size()-1){
        if(auxListLeft.size() == 0 && auxListRight.size() == 0){
            break
        }
        if(auxListLeft.size()== 0){
            finalList += auxListRight[0]
            auxListRight.remove(0)
        }else if(auxListRight.size() == 0){
            finalList += auxListLeft[0]
            auxListLeft.remove(0)
        }
        else if(auxListLeft[0] > auxListRight[0]){
            finalList += auxListRight[0]
            auxListRight.remove(0)
            }else{
                finalList+= auxListLeft[0]
                auxListLeft.remove(0)
            }
        }
    }
    items= finalList

}
return items
​