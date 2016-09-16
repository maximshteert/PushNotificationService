#ifndef STATIC_LINK
#define IMPLEMENT_API
#endif

#if defined(HX_WINDOWS) || defined(HX_MACOS) || defined(HX_LINUX)
#define NEKO_COMPATIBLE
#endif


#include <hx/CFFI.h>
#include "Utils.h"


using namespace pushnotificationservice;



static value pushnotificationservice_sample_method (value inputValue) {
	
	int returnValue = SampleMethod(val_int(inputValue));
	return alloc_int(returnValue);
	
}
DEFINE_PRIM (pushnotificationservice_sample_method, 1);



extern "C" void pushnotificationservice_main () {
	
	val_int(0); // Fix Neko init
	
}
DEFINE_ENTRY_POINT (pushnotificationservice_main);



extern "C" int pushnotificationservice_register_prims () { return 0; }