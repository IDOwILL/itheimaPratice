import{b as p,c as f,i as n,L as u}from"./report-01b0cc62.js";import{d as _,i as m,o as b,c as h,F as y,p as x,h as g,e as i,_ as S}from"./index-de6d9716.js";import"./request-24d06a0f.js";import"./loginEmp-cb0c9dd4.js";const r=o=>(x("data-v-b14d4ff6"),o=o(),g(),o),C=r(()=>i("div",{class:"report_container",id:"container1"},null,-1)),v=r(()=>i("div",{class:"report_container",id:"container2"},null,-1)),L=_({__name:"index",setup(o){m(()=>{s(),d()});const s=async()=>{let t=await p(),e=t.data.clazzList,a=t.data.dataList;l(e,a)},d=async()=>{let t=await f();c(t.data)};function l(t,e){var a=n(document.getElementById("container1"));a.setOption({title:{text:"班级人数统计",subText:"",textStyle:{fontSize:20},left:"center"},grid:{left:"3%",right:"4%",bottom:"3%",containLabel:!0},tooltip:{},xAxis:{data:t},yAxis:{},series:[{name:"人数",type:"bar",data:e,itemStyle:{color:new u(0,0,1,1,[{offset:0,color:"#ffbf61"},{offset:1,color:"#dd5f85"}])}}]})}function c(t){var e=n(document.getElementById("container2"));let a={title:{text:"学员学历统计",subText:"",textStyle:{fontSize:20},left:"center"},grid:{left:"3%",right:"4%",bottom:"3%",containLabel:!0},tooltip:{trigger:"item"},legend:{top:"10%",left:"center"},series:[{name:"学历",type:"pie",radius:["40%","70%"],avoidLabelOverlap:!1,top:"5%",itemStyle:{borderRadius:5,borderColor:"#fff",borderWidth:2},label:{show:!1,position:"center"},emphasis:{label:{show:!0,fontSize:20,fontWeight:"bold"}},data:t}]};e.setOption(a)}return(t,e)=>(b(),h(y,null,[C,v],64))}});const D=S(L,[["__scopeId","data-v-b14d4ff6"]]);export{D as default};
