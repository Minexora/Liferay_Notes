os.Loader={};
os.Loader.loadedUrls_={};
os.Loader.loadUrl=function(A,B){if(typeof (window.gadgets)!="undefined"){os.Loader.requestUrlGadgets_(A,B)
}else{os.Loader.requestUrlXHR_(A,B)
}};
os.Loader.requestUrlXHR_=function(A,C){if(os.Loader.loadedUrls_[A]){window.setTimeout(C,0);
return 
}var B=null;
if(typeof shindig!="undefined"&&shindig.xhrwrapper&&shindig.xhrwrapper.createXHR){B=shindig.xhrwrapper.createXHR()
}else{if(typeof XMLHttpRequest!="undefined"){B=new XMLHttpRequest()
}else{B=new ActiveXObject("MSXML2.XMLHTTP")
}}B.open("GET",A,true);
B.onreadystatechange=function(){if(B.readyState==4){os.Loader.loadContent(B.responseText,A);
C()
}};
B.send(null)
};
os.Loader.requestUrlGadgets_=function(B,D){var C={};
var A=window.gadgets;
if(os.Loader.loadedUrls_[B]){window.setTimeout(D,0);
return 
}C[A.io.RequestParameters.CONTENT_TYPE]=A.io.ContentType.TEXT;
A.io.makeRequest(B,function(E){os.Loader.loadContent(E.data,B);
D()
},C)
};
os.Loader.loadUrls=function(B,C){var A=function(){if(B.length==0){C()
}else{os.Loader.loadUrl(B.pop(),A)
}};
A()
};
os.Loader.loadContent=function(D,A){var C=gadgets.jsondom.parse(D,A);
var B=C.firstChild;
os.Loader.processTemplatesNode(B);
os.Loader.loadedUrls_[A]=true
};
os.Loader.getProcessorFunction_=function(A){return os.Loader["process"+A+"Node"]||null
};
os.Loader.processTemplatesNode=function(B){if(B.firstChild){B=B.firstChild
}for(var C=B;
C;
C=C.nextSibling){if(C.nodeType==DOM_ELEMENT_NODE){var A=os.Loader.getProcessorFunction_(C.tagName);
if(A){A(C)
}}}};
os.Loader.processNamespaceNode=function(B){var C=B.getAttribute("prefix");
var A=B.getAttribute("url");
os.createNamespace(C,A)
};
os.Loader.processTemplateDefNode=function(D){var A=D.getAttribute("tag");
var B=D.getAttribute("name");
for(var E=D.firstChild;
E;
E=E.nextSibling){if(E.nodeType==DOM_ELEMENT_NODE){var C=os.Loader.getProcessorFunction_(E.tagName);
if(C){C(E,A,B)
}}}};
os.Loader.processTemplateNode=function(F,H,G){var C=H||F.getAttribute("tag");
var D=G||F.getAttribute("name");
if(C){var B=C.split(":");
if(B.length!=2){throw Error("Invalid tag name: "+C)
}var A=os.getNamespace(B[0]);
if(!A){throw Error("Namespace not registered: "+B[0]+" while trying to define "+C)
}var E=os.compileXMLNode(F);
A[B[1]]=os.createTemplateCustomTag(E)
}else{if(D){var E=os.compileXMLNode(F);
E.id=D;
os.registerTemplate(E)
}}};
os.Loader.processJavaScriptNode=function(B,C){for(var A=B.firstChild;
A;
A=A.nextSibling){os.Loader.injectJavaScript(A.nodeValue)
}};
os.Loader.processStyleNode=function(B,C){for(var A=B.firstChild;
A;
A=A.nextSibling){os.Loader.injectStyle(A.nodeValue)
}};
os.Loader.headNode_=document.getElementsByTagName("head")[0]||document.getElementsByTagName("*")[0];
os.Loader.injectJavaScript=function(B){var A=document.createElement("script");
A.type="text/javascript";
A.text=B;
os.Loader.headNode_.appendChild(A)
};
os.Loader.injectStyle=function(B){var D;
if(document.styleSheets.length==0){document.getElementsByTagName("head")[0].appendChild(document.createElement("style"))
}D=document.styleSheets[0];
var G=B.split("}");
for(var C=0;
C<G.length;
C++){var F=G[C].replace(/\n/g,"").replace(/\s+/g," ");
try{if(F.length>2){if(D.insertRule){F=F+"}";
D.insertRule(F,D.cssRules.length)
}else{var A=F.split("{");
D.addRule(A[0],A[1])
}}}catch(E){gadgets.error("Error in stylesheet: "+F+" - "+E.name+" - "+E.message)
}}};