package kemptonfarms.org.api;

import com.wordnik.swagger.annotations.*;

import kemptonfarms.org.model.Forecasts;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import kemptonfarms.org.api.NotFoundException;

//import javax.ws.rs.core.Response;
//import javax.ws.rs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * the forecasts API
 */
@Controller
@RequestMapping(value = "/forecasts")
@Api(value = "/forecasts", description = "the forecasts API")
public class ForecastsApi {

  private ForecastsApiWorker worker;
  @Autowired
  public void setForecastsApiWorker(ForecastsApiWorker worker){
    this.worker = worker;
  }
  
  /**
   * Run a GET with ZIP code in the path, get output as HTML page
   *
   * 
   * 
   * @return String response
   */
  
  @RequestMapping(value="/htmltable/{input}", method={RequestMethod.GET})
  @ResponseBody
  @ApiOperation(value = "Run a GET with ZIP code in the path, get output as HTML page", notes = "", responseClass = "String")
  @ApiErrors(value = { @ApiError(code = 400, reason = "Bad Request"),@ApiError(code = 401, reason = "Unauthorized"),@ApiError(code = 403, reason = "Forbidden"),@ApiError(code = 404, reason = "Not Found"),@ApiError(code = 405, reason = "Method Not Allowed"),@ApiError(code = 408, reason = "Request Timeout"),@ApiError(code = 415, reason = "Unsupported Media Type"),@ApiError(code = 424, reason = "Method Failure"),@ApiError(code = 500, reason = "Internal Server Error"),@ApiError(code = 501, reason = "Not Implemented"),@ApiError(code = 502, reason = "Bad Gateway"),@ApiError(code = 503, reason = "Service Unavailable"),@ApiError(code = 504, reason = "Gateway Timeout")})
  public String htmltable(
    @ApiParam(value = "ZIP code"
      ,required=true)
    @PathVariable(value = "input")String input
    ,HttpServletRequest request, HttpServletResponse response
  ) throws NotFoundException {
      
      return worker.htmltable(
        input
        ,request, response);
      }

  /**
   * Run a GET with ZIP code in the path, get output as JSON array
   *
   * 
   * 
   * @return Forecasts response
   */
  
  @RequestMapping(value="/json/{input}", method={RequestMethod.GET})
  @ResponseBody
  @ApiOperation(value = "Run a GET with ZIP code in the path, get output as JSON array", notes = "", responseClass = "Forecasts")
  @ApiErrors(value = { @ApiError(code = 400, reason = "Bad Request"),@ApiError(code = 401, reason = "Unauthorized"),@ApiError(code = 403, reason = "Forbidden"),@ApiError(code = 404, reason = "Not Found"),@ApiError(code = 405, reason = "Method Not Allowed"),@ApiError(code = 408, reason = "Request Timeout"),@ApiError(code = 415, reason = "Unsupported Media Type"),@ApiError(code = 424, reason = "Method Failure"),@ApiError(code = 500, reason = "Internal Server Error"),@ApiError(code = 501, reason = "Not Implemented"),@ApiError(code = 502, reason = "Bad Gateway"),@ApiError(code = 503, reason = "Service Unavailable"),@ApiError(code = 504, reason = "Gateway Timeout")})
  public Forecasts json(
    @ApiParam(value = "ZIP code"
      ,required=true)
    @PathVariable(value = "input")String input
    ,HttpServletRequest request, HttpServletResponse response
  ) throws NotFoundException {
      
      return worker.json(
        input
        ,request, response);
      }

  /**
   * Run a GET with ZIP code in the path, get output as XML document
   *
   * 
   * 
   * @return String response
   */
  
  @RequestMapping(value="/xml/{input}", method={RequestMethod.GET})
  @ResponseBody
  @ApiOperation(value = "Run a GET with ZIP code in the path, get output as XML document", notes = "", responseClass = "String")
  @ApiErrors(value = { @ApiError(code = 400, reason = "Bad Request"),@ApiError(code = 401, reason = "Unauthorized"),@ApiError(code = 403, reason = "Forbidden"),@ApiError(code = 404, reason = "Not Found"),@ApiError(code = 405, reason = "Method Not Allowed"),@ApiError(code = 408, reason = "Request Timeout"),@ApiError(code = 415, reason = "Unsupported Media Type"),@ApiError(code = 424, reason = "Method Failure"),@ApiError(code = 500, reason = "Internal Server Error"),@ApiError(code = 501, reason = "Not Implemented"),@ApiError(code = 502, reason = "Bad Gateway"),@ApiError(code = 503, reason = "Service Unavailable"),@ApiError(code = 504, reason = "Gateway Timeout")})
  public String xml(
    @ApiParam(value = "ZIP code"
      ,required=true)
    @PathVariable(value = "input")String input
    ,HttpServletRequest request, HttpServletResponse response
  ) throws NotFoundException {
      
      return worker.xml(
        input
        ,request, response);
      }

  }

