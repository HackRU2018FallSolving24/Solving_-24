package com.example.danni.a24;

public class Make {

    static String cheat(int[] array) {
        //sort array

        for (int i=1; i<array.length;i++) {
            if(array[i]<array[i-1]) {
                int temp=array[i];
                array[i]=array[i-1];
                array[i-1]=temp;
                for(int j=i-1;j>0;j--) {
                    if(array[j]>=array[j-1]) {
                        break;
                    }else {
                        int ex=array[j];
                        array[j]=array[j-1];
                        array[j-1]=ex;
                    }
                }
            }
        }
        int n1=array[0];
        int n2=array[1];
        int n3=array[2];
        int n4=array[3];

        System.out.println(n1+" "+n2+" "+n3+" "+n4+" ");



        if(n1+n2+n3+n4==24) {
            return ""+n1+"+"+n2+"+"+n3+"+"+n4;
        }
        if(n1==2&&n2==4&&n3==10&&n4==10||n1==4&&n2==2&&n3==10&&n4==10||n1==4&&n2==10&&n3==10&&n4==2
                ||n1==2&&n2==10&&n3==10&&n4==4||n1==10&&n2==10&&n3==4&&n4==2||n1==10&&n2==10&&n3==2&&n4==4||
                n1==10&&n2==2&&n3==4&&n4==10||n1==10&&n2==4&&n3==2&&n4==10||n1==10&&n2==2&&n3==10&&n4==4||
                n1==10&&n2==4&&n3==10&&n4==2||n1==2&&n2==10&&n3==4&&n4==10||n1==4&&n2==10&&n3==2&&n4==10) {
            return "10*(2+(4/10))";
        }
        //if the array  has the number 2,3,4,6,8
        int[] imports= {2,3,4,6,8};
        String results;

        for(int i=0; i<array.length;i++) {

            for(int j=0;j<imports.length;j++) {
                if(array[i]==imports[j]) {
                    String anotherPart=Method.subMake((24/array[i]), delete(array[i],array));
                    //	System.out.println(anotherPart);
                    if(anotherPart!=null) {
                        results=""+array[i]+"*("+anotherPart+")";
                        return results;}else {
                        break;
                    }
                }else {
                    if(array[i]>imports[j]) {
                        delete(imports[j],imports);
                        continue;
                    }else {
                        break;
                    }
                }

            }

        }

        //if not, we check if there r two pairs could be either 2&12, 3&8, 4&6

        String pr1=null;
        String pr2=null;
        int[] arr1= {n1,n2};
        int[] arr2= {n3,n4};
        pr1=Method.subMake(12,arr1);
        pr2=Method.subMake(2,arr2);
        if(pr1!=null&&pr2!=null) {
            return "("+pr1+")*("+pr2+")";
        }
        for(int i=0;i<imports.length;i++) {
            pr1=Method.subMake(imports[i],arr1);
            pr2=Method.subMake(24/imports[i],arr2);
            if(pr1!=null&&pr2!=null) {
                return "("+pr1+")*("+pr2+")";
            }
        }

        arr1[1]= n3;
        arr2[0]= n2;

        pr1=Method.subMake(12,arr1);
        pr2=Method.subMake(2,arr2);
        if(pr1!=null&&pr2!=null) {
            return "("+pr1+")*("+pr2+")";
        }
        for(int i=0;i<imports.length;i++) {
            pr1=Method.subMake(imports[i],arr1);
            pr2=Method.subMake(24/imports[i],arr2);
            if(pr1!=null&&pr2!=null) {
                return "("+pr1+")*("+pr2+")";
            }
        }


        arr1[1]=n4;
        arr2[1]=n3;
        pr1=Method.subMake(12,arr1);
        pr2=Method.subMake(2,arr2);
        if(pr1!=null&&pr2!=null) {
            return "("+pr1+")*("+pr2+")";
        }
        for(int i=0;i<imports.length;i++) {
            pr1=Method.subMake(imports[i],arr1);
            pr2=Method.subMake(24/imports[i],arr2);
            if(pr1!=null&&pr2!=null) {
                return "("+pr1+")*("+pr2+")";
            }
        }

        //if a combination of 3 items +/- a number equals 24

        for(int i=14; i<24;i++) {
            if(n1==24-i||n2==24-i||n3==24-i||n4==24-i) {
                results=Method.subMake(i, delete(24-i,array));
                if(results!=null) {
                    return ""+(24-i)+"+("+results+")";
                }
            }

        }
        for(int i=25; i<35;i++) {
            if(n1==i-24||n2==i-24||n3==i-24||n4==i-24) {
                results=Method.subMake(i, delete(i-24,array));
                if(results!=null) {
                    return "("+results+")"+"-"+(i-24);
                }

            }

        }
        //if a combination of 2 item +/- another combination of 2 item equals 24

        //+
        int[] arrayForAdd= {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        String addpr1=null;
        String addpr2=null;
        int[] addarr1= {n1,n2};
        int[] addarr2= {n3,n4};

        for(int i=0;i<arrayForAdd.length;i++) {
            addpr1=Method.subMake(arrayForAdd[i],addarr1);
            addpr2=Method.subMake(24-arrayForAdd[i],addarr2);
            if(addpr1!=null&&addpr2!=null) {
                return addpr1+"+"+addpr2;
            }
        }

        addarr1[1]= n3;
        addarr2[0]= n2;
        for(int i=0;i<arrayForAdd.length;i++) {
            addpr1=Method.subMake(arrayForAdd[i],addarr1);
            addpr2=Method.subMake(24-arrayForAdd[i],addarr2);
            if(addpr1!=null&&addpr2!=null) {
                return addpr1+"+"+addpr2;
            }
        }



        addarr1[1]=n4;
        addarr2[1]=n3;

        for(int i=0;i<arrayForAdd.length;i++) {
            addpr1=Method.subMake(arrayForAdd[i],addarr1);
            addpr2=Method.subMake(24-arrayForAdd[i],addarr2);
            if(addpr1!=null&&addpr2!=null) {
                return addpr1+"+"+addpr2;
            }
        }

//-
        int[] minus1= {30,32,36,40,48,60,72,80};
        int[] minus2= {4,8,12,16,24,36,48,56};

        String minstr1=null;
        String minstr2=null;
        int[] minusarray1= {n1,n2};
        int[] minusarray2= {n3,n4};
        for(int i=0;i<minus1.length;i++) {
            minstr1=Method.subMake(minus1[i],minusarray1);
            minstr2=Method.subMake(minus1[i]-24, minusarray2);
            if(minstr1!=null&&minstr2!=null) {
                return minstr1+"-("+minstr2+")";
            }
        }
        for(int i=0;i<minus2.length;i++) {
            minstr1=Method.subMake(minus2[i],minusarray1);
            minstr2=Method.subMake(minus2[i]+24, minusarray2);
            if(minstr1!=null&&minstr2!=null) {
                return minstr2+"-("+minstr1+")";
            }
        }
        minus1[1]=n3;
        minus2[0]=n2;
        for(int i=0;i<minus1.length;i++) {
            minstr1=Method.subMake(minus1[i],minusarray1);
            minstr2=Method.subMake(minus1[i]-24, minusarray2);
            if(minstr1!=null&&minstr2!=null) {
                return minstr1+"-("+minstr2+")";
            }
        }
        for(int i=0;i<minus2.length;i++) {
            minstr1=Method.subMake(minus2[i],minusarray1);
            minstr2=Method.subMake(minus2[i]+24, minusarray2);
            if(minstr1!=null&&minstr2!=null) {
                return minstr2+"-("+minstr1+")";
            }
        }

        minus1[1]=n4;
        minus2[1]=n3;
        for(int i=0;i<minus1.length;i++) {
            minstr1=Method.subMake(minus1[i],minusarray1);
            minstr2=Method.subMake(minus1[i]-24, minusarray2);
            if(minstr1!=null&&minstr2!=null) {
                return minstr1+"-("+minstr2+")";
            }
        }
        for(int i=0;i<minus2.length;i++) {
            minstr1=Method.subMake(minus2[i],minusarray1);
            minstr2=Method.subMake(minus2[i]+24, minusarray2);
            if(minstr1!=null&&minstr2!=null) {
                return minstr2+"-("+minstr1+")";
            }
        }




        return "We could not get 24 in this case.";
    }


    static int[] delete(int target, int[] origin) {
        int[] yes= new int[origin.length-1];
        int count=0;
        boolean deleted=false;
        for(int i=0; i<origin.length;i++) {
            if(origin[i]!=target||deleted) {
                yes[count]=origin[i];
                count++;
            }else {
                deleted=true;
            }
        }

        return yes;
    }
}
